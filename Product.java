package Task.En;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProdId")
	private int productId;

	@Column(name = "ProductName ")
	private String productName;

	@Column(name = "ProductDescription")
	private String productDescription;

	@Column(name = "ProductPrice")
	private double productPrice;

	// Product To OrderItemsPrimay -----------------(OneToMany)
	@OneToMany(mappedBy = "productorderitem")
	@JsonIgnore
	private List<OrderItemsPrimary> orderitemsprimaryproduct;

	public Product() {
		super();

	}

	public Product(int productId, String productName, String productDescription, double productPrice,
			List<OrderItemsPrimary> orderitemsprimaryproduct) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.orderitemsprimaryproduct = orderitemsprimaryproduct;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public List<OrderItemsPrimary> getOrderitemsprimaryproduct() {
		return orderitemsprimaryproduct;
	}

	public void setOrderitemsprimaryproduct(List<OrderItemsPrimary> orderitemsprimaryproduct) {
		this.orderitemsprimaryproduct = orderitemsprimaryproduct;
	}

}