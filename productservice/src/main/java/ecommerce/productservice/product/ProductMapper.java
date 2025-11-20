package ecommerce.productservice.product;

import org.springframework.stereotype.Component;

import ecommerce.productservice.category.Category;
@Component
public class ProductMapper {

	//Converts product request coming from API into Entity(Product)
	public Product toProduct(ProductRequest request) {
		Product product = new Product();
		product.setId(request.id());
		product.setName(request.name());
		product.setDescription(request.description());
		product.setAvialableQuantity(request.availableQuantity());
		product.setPrice(request.price());
		
		Category category = new Category();
		category.setId(request.CategoryId());
		product.setCategory(category);
		;
		return product;
		
	}
	
	//Converts Product (domain/entity) into ProductResponse (API Response DTO)
	public ProductResponse toProductResponse(Product product) {
		return new ProductResponse(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getAvialableQuantity(),
				product.getPrice(),
				product.getCategory().getId(),
				product.getCategory().getName(),
				product.getCategory().getDescription()
				);
	}
	
	//Converts Product(domain/entity) into ProductPurchaseResponse (DTO for purchase flow)
	
	public ProductPurchaseResponse toProductPurchaseResponse(Product product,double quantity) {
		return new ProductPurchaseResponse(
				product.getId(),
				product.getName(),
				product.getDescription(),
				quantity,
				product.getPrice()
				
				);
	}
}
