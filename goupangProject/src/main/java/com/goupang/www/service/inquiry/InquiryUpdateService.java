package com.goupang.www.service.inquiry;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goupang.www.dao.inquiry.InquiryDAO;
import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.dto.inquiry.InquiryRequest;
import com.goupang.www.dto.inquiry.InquiryUpdate;


@Service
@Transactional
public class InquiryUpdateService {
	
	@Autowired
	private InquiryDAO inquiryDAO;

	public void insertInquiryList(InquiryRequest inquiryReq) throws Exception {
		
		//System.out.println("selectInquiryList:"+inquiryReq.toString());
		
		inquiryDAO.insertInquiry(
				inquiryReq.getMemberNo(),
				inquiryReq.getProductNo(),
				inquiryReq.getProductName() + " 에 대한 문의 입니다.",
				inquiryReq.getInquiryContent()
				);
	}

	
	public InquiryUpdate selectInquiry(int inquiryNo) {
		 List<Inquiry> inquiryList = inquiryDAO.selectInquiryByInquiryNo(inquiryNo);
		 Inquiry inquiry = inquiryList.get(0);
//		 inquiryUpdate.setInquiryNo(1);
//			inquiryUpdate.setMemberNo(1);
//			inquiryUpdate.setInquiryContent("");
//			inquiryUpdate.setProductName("상품번호1의 상품명");
//			inquiryUpdate.setMemberName("맴버이름");
		return null;
	}


	public void updateInquiry(Inquiry inquiry)throws Exception {
		inquiryDAO.updateInquiry(
				inquiry.getInquiryContent(),
				inquiry.getInquiryNo()
				);
	}

}


	


