package com.goupang.www.dto.inquiry;

public class InquiryList {
	private int inquiryNo;  /*NOT NULL, 문의번호 */
	private int memberNo; /*NOT NULL, 회원번호 */
	private int productNo;  /*NOT NULL, 상품번호 */
	private String inquiryTitle;  /* 문의제목 */
	private String inquiryContent;  /* 문의내용 */
	private String inquiryWrtDate;  /* 문의작성일 */
	private String inquiryModDate;  /* 문의수정일 */
	private String inquiryDelDate; /* 문의삭제일 */
	
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
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
	public String getInquiryTitle() {
		return inquiryTitle;
	}
	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public String getInquiryWrtDate() {
		return inquiryWrtDate;
	}
	public void setInquiryWrtDate(String inquiryWrtDate) {
		this.inquiryWrtDate = inquiryWrtDate;
	}
	public String getInquiryModDate() {
		return inquiryModDate;
	}
	public void setInquiryModDate(String inquiryModDate) {
		this.inquiryModDate = inquiryModDate;
	}
	public String getInquiryDelDate() {
		return inquiryDelDate;
	}
	public void setInquiryDelDate(String inquiryDelDate) {
		this.inquiryDelDate = inquiryDelDate;
	}

	
	
}
