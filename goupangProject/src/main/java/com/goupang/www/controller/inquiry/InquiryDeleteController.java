package com.goupang.www.controller.inquiry;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.service.inquiry.InquiryDeleteService;


@Controller
public class InquiryDeleteController {
	@Autowired
	private InquiryDeleteService inquiryDeleteService;
//	@Autowired
//	private InquiryListService inquiryListService;
	
	@GetMapping("/inquiry/inquiryDelete")
	public String delete(RedirectAttributes redirect,@ModelAttribute Inquiry inquiry,HttpServletRequest req,@RequestParam(defaultValue="1") int curPage)throws Exception{
		
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		int inquiryNo = Integer.parseInt(req.getParameter("inquiryNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		//인증부분
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		
		if(auth == null || auth.getGrant() < 1 || !auth.checkId((long)memberNo)) {
			return "redirect:/member/noGrant";	
		}
		String error = inquiryDeleteService.deleteInquiry(inquiryNo);
		//post로 넘기기. 받은쪽에서 새로고침하면 사라지는 값이니 주의
		//redirect.addFlashAttribute("productNo", productNo).addFlashAttribute("error", error);
		//get방식으로 넘기기
		//redirect.addAttribute("curPage", 1);
		redirect.addAttribute("productNo", productNo);
		//redirect.addAttribute("error", error);
		return "redirect:/product/productDetailList";
	}

	
	
}
