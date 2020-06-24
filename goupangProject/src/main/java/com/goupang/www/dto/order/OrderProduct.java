package com.goupang.www.dto.order;

public class OrderProduct {
	private int productNo;
	private int orderQty;
	
	public OrderProduct() {
	}
	
	public OrderProduct(int productNo, int orderQty) {
		this.productNo = productNo;
		this.orderQty = orderQty;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	@Override
	public String toString() {
		return "orderProduct [productNo=" + productNo + ", orderQty=" + orderQty + "]";
	}
	
	
}
