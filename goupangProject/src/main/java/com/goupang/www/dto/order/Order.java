package com.goupang.www.dto.order;


public class Order {
	private int orderProductsNo;
	private int memberNo;
	private int productNo;
	private String productName;
	private int paymentNo;
	private int orderQty;
	private String orderDate;
	private String deliveryStatus;
	private String orderDeliveryDestination;
	private int orderStatus;
	private String orderStatusDate;
	public int getOrderProductsNo() {
		return orderProductsNo;
	}
	public void setOrderProductsNo(int orderProductsNo) {
		this.orderProductsNo = orderProductsNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getOrderDeliveryDestination() {
		return orderDeliveryDestination;
	}
	public void setOrderDeliveryDestination(String orderDeliveryDestination) {
		this.orderDeliveryDestination = orderDeliveryDestination;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatusDate() {
		return orderStatusDate;
	}
	public void setOrderStatusDate(String orderStatusDate) {
		this.orderStatusDate = orderStatusDate;
	}
	@Override
	public String toString() {
		return "Order [orderProductsNo=" + orderProductsNo + ", memberNo=" + memberNo + ", productNo=" + productNo
				+ ", productName=" + productName + ", paymentNo=" + paymentNo + ", orderQty=" + orderQty
				+ ", orderDate=" + orderDate + ", deliveryStatus=" + deliveryStatus + ", orderDeliveryDestination="
				+ orderDeliveryDestination + ", orderStatus=" + orderStatus + ", orderStatusDate=" + orderStatusDate
				+ "]";
	}
	
	
	
	
}
