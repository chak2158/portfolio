package com.goupang.www.controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.controller.inquiry.Pagination;
import com.goupang.www.dto.review.Review;
import com.goupang.www.service.review.ReviewListService;

@Controller
public class reviewListController {
	@Autowired
	private ReviewListService reviewListService;
	
	@GetMapping("/review/reviewList")
	public String getList(
			Model model, @ModelAttribute("review") Review review,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam int productNo,
			HttpServletRequest request
			)throws Exception{
		int listCnt = reviewListService.selectReviewCountByProductNo(productNo);
		Pagination pagination = new Pagination(listCnt, curPage);
		List<Review> reviewProductNoList = reviewListService.selectReviewByProductNoList(pagination.getStartIndex(),(pagination.getStartIndex()+pagination.getPageSize()), productNo);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);
		model.addAttribute("reviewProductNoList", reviewProductNoList);
		model.addAttribute("productNo", productNo);

		return "/review/reviewList";
	}
	
//	@RequestMapping("/review/reviewList")
//	public String list(Model model, @ModelAttribute("review") Review review) throws Exception {
//		
//		int productNo = 1;
//		//List<Review> reviewList = reviewListService.selectReviewByOrderProductsNoList(orderProductsNo);
//		List<Review> reviewList = reviewListService.selectReviewByProductNoList(productNo);
//		model.addAttribute("reviewList", reviewList);
//		return "/review/reviewList";
//	}
//	@PostMapping("review/reviewList")
//	public String postList(Model model, @ModelAttribute("review") Review review, HttpServletRequest req) throws Exception {
//		Map<String,?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
//		if(inputFlashMap != null) {
//			int productNo = (int) inputFlashMap.get("productNo");
//			String error = (String) inputFlashMap.get("error");
//			List<Review> reviewList = reviewListService.selectReviewByProductNoList(productNo);
//			model.addAttribute("reviewList", reviewList);
//			model.addAttribute("productNo", productNo);
//			model.addAttribute("error", error);
//		}
//		
//		return "review/reviewList";
//	}
}
