package com.goupang.www.dto.inquiry;

public class InquiryReplyRequest {
	private int sellerNo; /*NOT NULL, 판매자번호 */
	private int inquiryNo; /*NOT NULL, 문의번호 */
	private int productNo; //상품번호
	private String replyContent; /* 문의답변내용 */
	private String productName; //상품이름
	public InquiryReplyRequest(){}
	public InquiryReplyRequest(int sellerNo, int inquiryNo, int productNo, String replyContent, String productName) {
		
		this.sellerNo = sellerNo;
		this.inquiryNo = inquiryNo;
		this.productNo = productNo;
		this.replyContent = replyContent;
		this.productName = productName;
	}
	public int getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	};
	
	

}
