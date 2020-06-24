package com.goupang.www.service.inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goupang.www.dao.inquiry.InquiryDAO;
import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.dto.inquiry.InquiryReply;

@Service
@Transactional
public class InquiryListService {
	
	@Autowired
	private InquiryDAO inquiryDAO;

//	public List<Inquiry> selectInquiryList(int productNo) throws Exception {
//		List<Inquiry> inquiryList =  inquiryDAO.selectInquiryList(productNo);
//		//문의에 해당하는 문의답변 목록을 문의에 저장
//		for(Inquiry i : inquiryList) {
//			i.setInquiryReplyList(inquiryDAO.selectInquiryReplyListByInquiryNo(i.getInquiryNo()));
//			//System.out.println("dsafdaszzzzzzzzzz"+i.getInquiryReplyList().get(0).getInquiryNo());
//
//		}
//		
//		return inquiryList;
//	}
	public List<Inquiry> selectInquiryList(int startIndex, int pageSize, int productNo) throws Exception {
		List<Inquiry> inquiryList =  inquiryDAO.selectInquiryList(startIndex,pageSize,productNo);
		//문의에 해당하는 문의답변 목록을 문의에 저장
		for(Inquiry i : inquiryList) {
			i.setInquiryReplyList(inquiryDAO.selectInquiryReplyListByInquiryNo(i.getInquiryNo()));
			//System.out.println("dsafdaszzzzzzzzzz"+i.getInquiryReplyList().get(0).getInquiryNo());
			
		}
		
		return inquiryList;
	}
	public int selectInquiryCnt(int productNo) {
		
		return inquiryDAO.selectInquiryCnt(productNo);
	}

}


	


