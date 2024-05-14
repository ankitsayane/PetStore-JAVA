package Com.Store;

import Com.Category.Status;

public class Order {
	private int orderId;
	private int petId;
	private int orderQuantity;
	private Status status;
	
	public static int count=0;
	
	public Order(int petId, int orderQuantity) {
		super();
		this.orderId = ++count;
		this.petId = petId;
		this.orderQuantity = orderQuantity;
		this.status = Status.PLACED;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", orderQuantity=" + orderQuantity + ", status="
				+ status + "]";
	}
	
	
}
