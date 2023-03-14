package model;

public class OrderDetail {
	private int orderDetailId;
	private Product product;
	private Order order;
	private int quantity;
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderDetail() {
		super();
	}
	public OrderDetail(int orderDetailId, Product product, Order order, int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}	
}
