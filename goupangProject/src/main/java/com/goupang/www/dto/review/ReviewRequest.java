package com.goupang.www.dto.review;

public class ReviewRequest {
	private int productNo;
	private String productName;
	private String productOption;
	private int orderProductsNo;
	private int orderStatus;
	private int memberNo;
	private String memberName;
	private int reviewRate;
	private String reviewContent;
	private String reviewSummary;
	
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
	public String getProductOption() {
		return productOption;
	}
	public void setProductOption(String productOption) {
		this.productOption = productOption;
	}
	public int getOrderProductsNo() {
		return orderProductsNo;
	}
	public void setOrderProductsNo(int orderProductsNo) {
		this.orderProductsNo = orderProductsNo;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewSummary() {
		return reviewSummary;
	}
	public void setReviewSummary(String reviewSummary) {
		this.reviewSummary = reviewSummary;
	}

	@Override
	public String toString() {
		return "ReviewRequest [productName=" + productName 
				+ ", memberName=" + memberName 
				+ ", reviewRate=" + reviewRate 
				+ ", reviewContent=" + reviewContent
				+ ", reviewSummary=" + reviewSummary + "]";
	}

}
