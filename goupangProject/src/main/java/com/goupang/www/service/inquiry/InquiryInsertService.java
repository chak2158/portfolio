package com.goupang.www.service.inquiry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.inquiry.InquiryDAO;
import com.goupang.www.dto.inquiry.InquiryReplyRequest;
import com.goupang.www.dto.inquiry.InquiryRequest;


@Service
@Transactional
public class InquiryInsertService {
	
	@Autowired
	private InquiryDAO inquiryDAO;

	public void insertInquiry(InquiryRequest inquiryReq) throws Exception {
		
		//System.out.println("selectInquiryList:"+inquiryReq.toString());
		
		inquiryDAO.insertInquiry(
				inquiryReq.getMemberNo(),
				inquiryReq.getProductNo(),
				inquiryReq.getProductName() + " 에 대한 문의 입니다.",
				inquiryReq.getInquiryContent()
				);
	}
	public void insertInquiryReply(InquiryReplyRequest inquiryReplyRequest) throws Exception {
		System.out.println("zeee:"+
				inquiryReplyRequest.getSellerNo()+
				inquiryReplyRequest.getInquiryNo()+
				inquiryReplyRequest.getReplyContent());
		
				inquiryDAO.insertInquiryReply(
				inquiryReplyRequest.getSellerNo(),
				inquiryReplyRequest.getInquiryNo(),
				inquiryReplyRequest.getReplyContent()
				);
	}

}


	


