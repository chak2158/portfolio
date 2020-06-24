package com.goupang.www.dto.review;

public class ReviewList {
	private int reviewNo;
	private int productNo;
	private int reviewRate;
	private String reviewContent;
	private String reviewSummary;
	private String reviewDate; 
	//앞으로 더 필요한 건 - 작성자 이름, 상품명 + 상품 옵션
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
}
