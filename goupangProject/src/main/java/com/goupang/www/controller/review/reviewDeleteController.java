package com.goupang.www.controller.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.review.Review;
import com.goupang.www.service.review.ReviewDeleteService;

@Controller
public class reviewDeleteController {
	@Autowired
	private ReviewDeleteService reviewDeleteService;
	
	@GetMapping("/review/reviewDelete")
	public String delete(RedirectAttributes redirect,@ModelAttribute Review review,HttpServletRequest req,@RequestParam(defaultValue="1") int curPage) throws Exception {
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		//인증
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		if(auth == null || auth.getGrant() < 1 || !auth.checkId((long)memberNo)) {
			return "redirect:/member/noGrant";	
		}
		String error = reviewDeleteService.deleteReview(reviewNo);
		//post로 넘기기-받아서 새로고침하면 없어지는 값이니 주의해야 한다고 한다
		//redirect.addFlashAttribute("productNo", productNo).addFlashAttribute("error", error);
		//get으로 넘기기
		//redirect.addAttribute("curPage", 1);
		redirect.addAttribute("productNo", productNo);
//		redirect.addAttribute("error",error);
		return "redirect:/product/productDetailList?productNo="+productNo;
	}
}
