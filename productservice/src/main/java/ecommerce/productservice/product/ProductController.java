package ecommerce.productservice.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<Integer>createProduct(@RequestBody @Valid ProductRequest request){
		return ResponseEntity.ok(productService.createProduct(request));
		
	}
	
	@PostMapping("/purchaseProduct")
	public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(@RequestBody List<ProductPurchaseRequest> request){
		return ResponseEntity.ok(productService.purchaseProducts(request));
		
	}
	
	
	@GetMapping("/{product-id}")
	public ResponseEntity<ProductResponse>findByID(@PathVariable("product-id" )Integer ProductId){
		return ResponseEntity.ok(productService.findById(ProductId));
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ProductResponse>>findAll(){
		return ResponseEntity.ok(productService.findAll());
		
	}
	
	

}
