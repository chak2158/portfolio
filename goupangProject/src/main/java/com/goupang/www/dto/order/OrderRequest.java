package com.goupang.www.dto.order;

import java.util.Arrays;

public class OrderRequest {
	private int memberNo;
	private OrderProduct orderProduct;
	private int paymentNo;
	private String orderDeliveryDestination;
	
	public OrderRequest() {
	}
	
	public OrderRequest(int memberNo, OrderProduct orderProduct, int paymentNo, String orderDeliveryDestination) {
		this.memberNo = memberNo;
		this.orderProduct = orderProduct;
		this.paymentNo = paymentNo;
		this.orderDeliveryDestination = orderDeliveryDestination;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public OrderProduct getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getOrderDeliveryDestination() {
		return orderDeliveryDestination;
	}
	public void setOrderDeliveryDestination(String orderDeliveryDestination) {
		this.orderDeliveryDestination = orderDeliveryDestination;
	}
	@Override
	public String toString() {
		return "OrderRequest [memberNo=" + memberNo + ", orderProduct=" + orderProduct + ", paymentNo=" + paymentNo
				+ ", orderDeliveryDestination=" + orderDeliveryDestination + "]";
	}
	
	
	
	
	
	

}
