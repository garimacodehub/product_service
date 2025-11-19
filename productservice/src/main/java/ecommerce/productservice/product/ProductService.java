package ecommerce.productservice.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
//	@Transactional(rollbackFor = ProductPurchaseException.class)
//	public List<ProductPurchaseResponse> purchaseProducts(
//			List<ProductPurchaseRequest> request){
//		var productIds = request
//				.stream()
//				.map(ProductPurchaseRequest::productid)
//				.toList();
//		
//		
//				return null;
//		
//	}
}
