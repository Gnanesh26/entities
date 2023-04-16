package Task.En;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderItems implements Serializable {

	@Column(name = "orderId")
	private int orderid;

	@Column(name = "ProdId")
	private int prodid;

	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(int orderid, int prodid) {
		super();
		this.orderid = orderid;
		this.prodid = prodid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderid, prodid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return orderid == other.orderid && prodid == other.prodid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

}