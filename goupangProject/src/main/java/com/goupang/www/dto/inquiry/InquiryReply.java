package com.goupang.www.dto.inquiry;

public class InquiryReply {
	private int inquiryReplyNo; /*NOT NULL, 문의답변번호 */
	private int sellerNo; /*NOT NULL, 판매자번호 */
	private int inquiryNo; /*NOT NULL, 문의번호 */
	private String replyContent; /* 문의답변내용 */
	private String replyWrtDate; /* 문의답변작성일 */
	private String replyModDate; /* 문의답변수정일 */
	private String replyDelDate;/* 문의답변삭제일 */
	
	public InquiryReply(){};
	public InquiryReply(int inquiryReplyNo, int sellerNo, int inquiryNo, String replyContent) {
		this.inquiryReplyNo = inquiryReplyNo;
		this.sellerNo = sellerNo;
		this.inquiryNo = inquiryNo;
		this.replyContent = replyContent;
	}

	public InquiryReply(int sellerNo, int inquiryNo, String replyContent, String replyWrtDate, String replyModDate,
			String replyDelDate) {
		
		this.sellerNo = sellerNo;
		this.inquiryNo = inquiryNo;
		this.replyContent = replyContent;
		this.replyWrtDate = replyWrtDate;
		this.replyModDate = replyModDate;
		this.replyDelDate = replyDelDate;
	}

	public InquiryReply(int inquiryReplyNo, int sellerNo, int inquiryNo, String replyContent, String replyWrtDate,
			String replyModDate, String replyDelDate) {
		
		this.inquiryReplyNo = inquiryReplyNo;
		this.sellerNo = sellerNo;
		this.inquiryNo = inquiryNo;
		this.replyContent = replyContent;
		this.replyWrtDate = replyWrtDate;
		this.replyModDate = replyModDate;
		this.replyDelDate = replyDelDate;
	}
	public int getInquiryReplyNo() {
		return inquiryReplyNo;
	}
	public void setInquiryReplyNo(int inquiryReplyNo) {
		this.inquiryReplyNo = inquiryReplyNo;
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
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWrtDate() {
		return replyWrtDate;
	}
	public void setReplyWrtDate(String replyWrtDate) {
		this.replyWrtDate = replyWrtDate;
	}
	public String getReplyModDate() {
		return replyModDate;
	}
	public void setReplyModDate(String replyModDate) {
		this.replyModDate = replyModDate;
	}
	public String getReplyDelDate() {
		return replyDelDate;
	}
	public void setReplyDelDate(String replyDelDate) {
		this.replyDelDate = replyDelDate;
	}
	

}
