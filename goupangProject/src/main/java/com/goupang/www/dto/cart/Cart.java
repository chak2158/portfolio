package com.goupang.www.dto.cart;


public class Cart {
	private int cartNo;
	private int memberNo;
	private String productName;
	private int productNo;
	private int orderQty;
	private int productPrice;
	private int totalPrice;
	
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public int getTotalPrice() {
		return orderQty*productPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", memberNo=" + memberNo + ", productName=" + productName + ", productNo="
				+ productNo + ", orderQty=" + orderQty + ", productPrice=" + productPrice + ", totalPrice=" + totalPrice
				+ "]";
	}
	
	
	

	

	
	
}
	