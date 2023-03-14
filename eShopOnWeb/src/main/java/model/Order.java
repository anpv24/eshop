package model;

import java.sql.Date;

public class Order {
	private int orderId;
	private int totalMoney;
	private String payment;
	private Date bookingDate;
	private Date deliveryDate;
	private String shippingWay;
	private int state;
	private String color;
	private String size;
	private String note;
	private int transportFee;
	private User user;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getShippingWay() {
		return shippingWay;
	}

	public void setShippingWay(String shippingWay) {
		this.shippingWay = shippingWay;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getTransportFee() {
		return transportFee;
	}

	public void setTransportFee(int transportFee) {
		this.transportFee = transportFee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Order(int orderId, int totalMoney, String payment, Date bookingDate, Date deliveryDate, String shippingWay,
			int state, String color, String size, String note, int transportFee, User user) {
		super();
		this.orderId = orderId;
		this.totalMoney = totalMoney;
		this.payment = payment;
		this.bookingDate = bookingDate;
		this.deliveryDate = deliveryDate;
		this.shippingWay = shippingWay;
		this.state = state;
		this.color = color;
		this.size = size;
		this.note = note;
		this.transportFee = transportFee;
		this.user = user;
	}

}
