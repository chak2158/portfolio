package com.goupang.www.controller.inquiry;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.service.inquiry.InquiryUpdateService;


@Controller
public class inquiryUpdateController {
	@Autowired
	private InquiryUpdateService inquiryUpdateService;

	@PostMapping("/inquiry/inquiryUpdateForm")
	public String form(@ModelAttribute Inquiry inquiry,HttpServletRequest req)throws Exception{
		System.out.println(inquiry.getInquiryNo());
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		
		if(auth == null || auth.getGrant() < 1 || !auth.checkId((long)inquiry.getMemberNo())) {
			return "redirect:/member/noGrant";	
		}
		return "/inquiry/inquiryUpdateForm";

	}
	@PostMapping("/inquiry/inquiryUpdate")
	public String submit(@ModelAttribute Inquiry inquiry)throws Exception {
		inquiryUpdateService.updateInquiry(inquiry);
		
		return "redirect:/product/productDetailList?productNo="+inquiry.getProductNo();
	}
	
	
}
