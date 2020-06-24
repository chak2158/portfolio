package com.goupang.www.dto.inquiry;

public class InquiryRequest {
	private int productNo;
	private int memberNo;
	private String inquiryContent;
	private String productName;
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "InquiryRequest [productNo=" + productNo + ", memberNo=" + memberNo + ", inquiryContent="
				+ inquiryContent + ", productName=" + productName + "]";
	}
	
	
}
