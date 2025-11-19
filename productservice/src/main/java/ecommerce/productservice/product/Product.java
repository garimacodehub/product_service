package ecommerce.productservice.product;

import java.math.BigDecimal;

import ecommerce.productservice.category.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	private double avialableQuantity;
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAvialableQuantity() {
		return avialableQuantity;
	}
	public void setAvialableQuantity(double avialableQuantity) {
		this.avialableQuantity = avialableQuantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", avialableQuantity="
				+ avialableQuantity + ", price=" + price + ", category=" + category + "]";
	}
	
	
	
	

}
