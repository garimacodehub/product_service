package ecommerce.productservice.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
		Integer productid,
		String name,
		String description,
		double quantity,
		BigDecimal price) {

	

}
