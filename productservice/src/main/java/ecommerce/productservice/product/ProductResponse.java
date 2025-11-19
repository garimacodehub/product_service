package ecommerce.productservice.product;

import java.math.BigDecimal;

public record ProductResponse(
		Integer id,
		String name,
		String description,
		double avaialbleQuantity,
		BigDecimal price,
		Integer Categoryid,
		String CategoryName,
		String categoryDescription
		) {

}
