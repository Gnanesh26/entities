package Task.En;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private int orderId;

	@Column(name = "OrderDate")
	private LocalDate orderDate;

	@Column(name = "OrderStatus")
	private String orderStatus;

	@Column(name = "DeliveryDate")
	private LocalDate deliveryDate;

	@Column(name = "Orderweight")
	private double orderweight;

	@Column(name = "WeightPrice")
	private double weightprice;

	@Column(name = "Amount")
	private double amount;

	@Column(name = "Id", insertable = false, updatable = false)
	private int customerId;

	// Order To Customer Relationship-------------------(ManyToOne)
	@ManyToOne
	@JoinColumn(name = "Id")
	private Customer customers;

	// Order To OrderItemsPrimary Relationship --------------(OneToMany)
	@OneToMany(mappedBy = "ordertoorderitems")
	@JsonIgnore
	private List<OrderItemsPrimary> orderitemsprimary;

	public Order() {
		super();

	}

	public Order(int orderId, LocalDate orderDate, String orderStatus, LocalDate deliveryDate, double orderweight,
			double weightprice, double amount, int customerId, Customer customers,
			List<OrderItemsPrimary> orderitemsprimary) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.deliveryDate = deliveryDate;
		this.orderweight = orderweight;
		this.weightprice = weightprice;
		this.amount = amount;
		this.customerId = customerId;
		this.customers = customers;
		this.orderitemsprimary = orderitemsprimary;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getOrderweight() {
		return orderweight;
	}

	public void setOrderweight(double orderweight) {
		this.orderweight = orderweight;
	}

	public double getWeightprice() {
		return weightprice;
	}

	public void setWeightprice(double weightprice) {
		this.weightprice = weightprice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public List<OrderItemsPrimary> getOrderitemsprimary() {
		return orderitemsprimary;
	}

	public void setOrderitemsprimary(List<OrderItemsPrimary> orderitemsprimary) {
		this.orderitemsprimary = orderitemsprimary;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}