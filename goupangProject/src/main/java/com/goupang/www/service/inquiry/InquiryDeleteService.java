package com.goupang.www.service.inquiry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.inquiry.InquiryDAO;


@Service
@Transactional
public class InquiryDeleteService {
	
	@Autowired
	private InquiryDAO inquiryDAO;

	public String deleteInquiry(int inquiryNo) {
		try {
			inquiryDAO.deleteInquiry(inquiryNo);
			return null;
		} catch (Exception e) {
			return "답변이 작성된 글은 삭제할 수 없습니다.";
		}
	}


}


	


