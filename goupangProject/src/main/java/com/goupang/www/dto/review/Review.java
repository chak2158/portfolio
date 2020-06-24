package com.goupang.www.dto.review;

public class Review {
	private int reviewNo; //NOT Null 리뷰 번호
	private int orderProductsNo; //not null 주문 내역 번호
	private int productNo; //not null 상품 번호
	private String productName;
	private String productOption;
	private int memberNo;
	private String memberName;
	private int reviewRate;  //not null 리뷰 점수
	private String reviewContent; //리뷰 내용
	private String reviewSummary; //리뷰 요약
	private String reviewDate; //리뷰 작성일
	
	public Review() {};

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getOrderProductsNo() {
		return orderProductsNo;
	}
	public void setOrderProducts_no(int orderProductsNo) {
		this.orderProductsNo = orderProductsNo;
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
	public String getProductOption() {
		return productOption;
	}
	public void setProductOption(String productOption) {
		this.productOption = productOption;
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
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

//	@Override
//	public String toString() {
//		return "Review [productNo=" + productNo + ", reviewRate=" + reviewRate //여기 멤버가 나와야 되는데 ㄲㄲ 다른데서 집어넣으면 된다고 한다.
//				+ ", reviewContent=" + reviewContent + ", reviewSummary=" + reviewSummary + ", reviewDate="
//				+ reviewDate + "]";
//	}
}
