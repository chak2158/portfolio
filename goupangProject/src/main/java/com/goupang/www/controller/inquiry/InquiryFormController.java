package com.goupang.www.controller.inquiry;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.dto.inquiry.InquiryReplyRequest;
import com.goupang.www.dto.inquiry.InquiryRequest;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.product.Product;
import com.goupang.www.service.inquiry.InquiryInsertService;
import com.goupang.www.service.product.ProductListService;


@Controller
public class InquiryFormController {
	
	@Autowired
	private InquiryInsertService inquiryInsertService;
	@Autowired
	private ProductListService productListService;
//	@Autowired
//	private InquiryListService inquiryListService;
	@GetMapping("/inquiry/inquiryForm")
	public String form(Model model,HttpServletRequest req,@RequestParam int productNo) throws Exception{
		InquiryRequest inquiryReq = new InquiryRequest();
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		if(auth == null || auth.getGrant() < 1 ) {
			return "redirect:/member/noGrant";	
		}
		inquiryReq.setMemberNo(auth.getId().intValue());//멤버번호
		/*원래는 다른 페이지에서 받아와야 되는 값들*/
		inquiryReq.setProductNo(productNo);//상품번호
		inquiryReq.setProductName(productListService.selectProductByProductNo(productNo).get(0).getProductName());

		model.addAttribute("inquiryRequest",inquiryReq);
		return "/inquiry/inquiryForm";
	}
	@PostMapping("/inquiry/inquiryForm")
	public String submit(Model model,@ModelAttribute Inquiry inquiry,InquiryRequest inquiryReq,@RequestParam int productNo)throws Exception {
		//System.out.println("submit:"+inquiryReq.toString());
		inquiryInsertService.insertInquiry(inquiryReq);
		
//		 List<Inquiry> inquiryList = inquiryListService.selectInquiryList(inquiry.getProductNo());
//		    model.addAttribute("inquiryList", inquiryList);
		return "redirect:/product/productDetailList?productNo="+productNo;
	}
	//답변이 달려있는지 체크할 필요는 없다. 추가답변이 필요할 수 있음
	@GetMapping("/inquiry/inquiryReplyForm")
	public String replyForm(Model model,HttpServletRequest req,InquiryReplyRequest inquiryReplyRequest,@RequestParam(defaultValue="1") int curPage) throws Exception{
		
		int inquiryNo = Integer.parseInt(req.getParameter("inquiryNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		Product product = productListService.selectProductByProductNo(productNo).get(0);
		int sellerNo = product.getSellerNo(); //상품 객체에 있는 판매자 번호
		
		String productName = product.getProductName();
		
		//인증객체 가져옴
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		//상품객체의 판매자 번호와 인증객체의 아이디값이 같은지 체크 - 상품 등록한 사람이랑 로그인한 사람이 같아야 문의에 대한 답변 작성 가능
		if(sellerNo != auth.getId().intValue()) {
			return "redirect:/member/noGrant";
		}if(auth.getGrant() < 2) {
			return "redirect:/member/noGrant";			
		}
		
		inquiryReplyRequest.setInquiryNo(inquiryNo);
		inquiryReplyRequest.setSellerNo(sellerNo);
		inquiryReplyRequest.setProductNo(productNo);
		inquiryReplyRequest.setProductName(productName);
		return "/inquiry/inquiryReplyForm";
	}
	@PostMapping("/inquiry/inquiryReplyForm")
	public String replySubmit(Model model,InquiryRequest inquiryReq,InquiryReplyRequest inquiryReplyRequest)throws Exception {
		//System.out.println("submit:"+inquiryReq.toString());
		//inquiryInsertService.insertInquiry(inquiryReq);
		inquiryInsertService.insertInquiryReply(inquiryReplyRequest);
//		 List<Inquiry> inquiryList = inquiryListService.selectInquiryList(inquiry.getProductNo());
//		    model.addAttribute("inquiryList", inquiryList);
		return "redirect:/product/productDetailList?productNo="+inquiryReplyRequest.getProductNo();
	}
	
	
}
