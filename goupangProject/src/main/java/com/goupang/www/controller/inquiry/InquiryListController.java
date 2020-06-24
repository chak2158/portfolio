package com.goupang.www.controller.inquiry;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.service.inquiry.InquiryListService;



@Controller
public class InquiryListController {
	@Autowired
	private InquiryListService inquiryListService;
	
//	@GetMapping("/inquiry/inquiryList")
//	public String getList(Model model, @ModelAttribute("inquiry") Inquiry inquiry)throws Exception {
//		//원래 다른곳에서 받아와야 할 상품번호
//		int productNo = 1;
//	    List<Inquiry> inquiryList = inquiryListService.selectInquiryList(productNo);
//	    
//	    model.addAttribute("inquiryList", inquiryList);
//	    
////	    Inquiry inquiry = new Inquiry();
////	    model.addAttribute("inquiry", inquiry);
//	    
//		return "/inquiry/inquiryList";
//	}
	
	@GetMapping("/inquiry/inquiryList")
	public String getList(
			Model model,
			@ModelAttribute("inquiry") Inquiry inquiry,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam int productNo,
            HttpServletRequest request
            )throws Exception {
		// 전체리스트 개수
        int listCnt = inquiryListService.selectInquiryCnt(productNo);
        Pagination pagination = new Pagination(listCnt, curPage);
	    List<Inquiry> inquiryList = inquiryListService.selectInquiryList(pagination.getStartIndex(),(pagination.getStartIndex()+pagination.getPageSize()),productNo);
        model.addAttribute("listCnt", listCnt);
        model.addAttribute("pagination", pagination);
	    model.addAttribute("inquiryList", inquiryList);
	    model.addAttribute("productNo", productNo);

		return "/inquiry/inquiryList";
	}
	
//	@PostMapping("/inquiry/inquiryList")
//	public String pistList(Model model, @ModelAttribute("inquiry") Inquiry inquiry,HttpServletRequest req)throws Exception {
//		Map<String,?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
//		if(inputFlashMap != null) {
//			int productNo = (int) inputFlashMap.get("productNo");
//			String error = (String) inputFlashMap.get("error");
//			List<Inquiry> inquiryList = inquiryListService.selectInquiryList(productNo);
//			model.addAttribute("inquiryList", inquiryList);		
//			model.addAttribute("productNo", productNo);		
//			model.addAttribute("error", error);		
//		}
////	    Inquiry inquiry = new Inquiry();
////	    model.addAttribute("inquiry", inquiry);
//		
//		return "/inquiry/inquiryList";
//	}
}
