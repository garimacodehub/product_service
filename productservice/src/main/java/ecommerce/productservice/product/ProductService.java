package ecommerce.productservice.product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ecommerce.productservice.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}
	
	//create product
	public Integer createProduct(ProductRequest request) {
		var product = productMapper.toProduct(request);
		return productRepository.save(product).getId();
	}
	
	//findById
	
	public ProductResponse findById(Integer id) {
		return productRepository.findById(id)
				.map(productMapper::toProductResponse)
				.orElseThrow(()-> new EntityNotFoundException("Product not found with ID:::"  + id));
	}
	//findAll
	 
	public List<ProductResponse> findAll(){
		return productRepository.findAll()
				.stream()
				.map(productMapper::toProductResponse)
				.collect(Collectors.toList());
		
	}
	
	//purchaseProducts
	@Transactional(rollbackOn = ProductPurchaseException.class)
	public List<ProductPurchaseResponse> purchaseProducts(
			List<ProductPurchaseRequest> request){
		var productIds = request
				.stream()
				.map(ProductPurchaseRequest::productid)
				.toList();
		
		var storedProducts = productRepository.findAllByIdInOrderById(productIds);
		if(productIds.size() != storedProducts.size()) {
			throw new ProductPurchaseException("One or more products does not exists");
		}
		
		var storedRequest = request
				.stream()
				.sorted(Comparator.comparing(ProductPurchaseRequest::productid))
				.toList();
		
		var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
		for(int i =0;i < storedProducts.size();i++) {
			var product = storedProducts.get(i);
			var productRequest = storedRequest.get(i);
			if(product.getAvialableQuantity()<productRequest.quantity()) {
				throw new ProductPurchaseException("Insufficient stock quantity for this product with ID ::" + productRequest.productid());
			}
			
			var newAvailableQuantity = product.getAvialableQuantity() - productRequest.quantity();
			product.setAvialableQuantity(newAvailableQuantity);
			productRepository.save(product);
			purchasedProducts.add(productMapper.toProductPurchaseResponse(product,productRequest.quantity()));
		}
		
		return purchasedProducts;
		
	}
}
