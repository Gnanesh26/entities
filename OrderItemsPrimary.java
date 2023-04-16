package Task.En;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderItems")
public class OrderItemsPrimary {

	@EmbeddedId
	private OrderItems orderitems;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Price")
	private double price;

	// OrderItemsPrimary To Product----------------(ManyToOne)
	@JsonIgnore
	@ManyToOne
	@MapsId(value = "prodid")
	@JoinColumn(name = "prodid")
	public  Product productorderitem;

	// OrderItemsPrimary To Order-------------(ManyToOne)
	@JsonIgnore
	@ManyToOne
	@MapsId(value = "orderid")
	@JoinColumn(name = "orderid")
	private  Order ordertoorderitems;

	public OrderItemsPrimary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemsPrimary(OrderItems orderitems, int quantity, double price, Product productorderitem,
			Order ordertoorderitems) {
		super();
		this.orderitems = orderitems;
		this.quantity = quantity;
		this.price = price;
		this.productorderitem = productorderitem;
		this.ordertoorderitems = ordertoorderitems;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderitems, ordertoorderitems, price, productorderitem, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemsPrimary other = (OrderItemsPrimary) obj;
		return Objects.equals(orderitems, other.orderitems)
				&& Objects.equals(ordertoorderitems, other.ordertoorderitems)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productorderitem, other.productorderitem) && quantity == other.quantity;
	}

	public OrderItems getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(OrderItems orderitems) {
		this.orderitems = orderitems;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProductorderitem() {
		return productorderitem;
	}

	public void setProductorderitem(Product productorderitem) {
		this.productorderitem = productorderitem;
	}

	public Order getOrdertoorderitems() {
		return ordertoorderitems;
	}

	public void setOrdertoorderitems(Order ordertoorderitems) {
		this.ordertoorderitems = ordertoorderitems;
	}

	@Override
	public String toString() {
		return "OrderItemsPrimary [orderitems=" + orderitems + ", quantity=" + quantity + ", price=" + price
				+ ", productorderitem=" + productorderitem + ", ordertoorderitems=" + ordertoorderitems + "]";
	}

}