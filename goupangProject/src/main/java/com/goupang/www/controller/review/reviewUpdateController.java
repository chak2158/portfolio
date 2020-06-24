package com.goupang.www.controller.review;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.review.Review;
import com.goupang.www.exception.review.WrongOrderProductsNoException;
import com.goupang.www.exception.review.WrongProductNoException;
import com.goupang.www.service.review.ReviewUpdateService;

@Controller
public class reviewUpdateController {
	@Autowired
	private ReviewUpdateService reviewUpdateService;

	@GetMapping("review/reviewUpdateForm")
	public String form(Model model, @RequestParam("reviewNo") int reviewNo, Review review,
			HttpServletRequest req) throws Exception {
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
//		if (auth == null || auth.getGrant() < 1 || !auth.checkId((long) review.getMemberNo())) {
//			return "redirect:/member/noGrant";
//		}
		Review selectReview = reviewUpdateService.selectReviewByReviewNo(reviewNo);
		if(selectReview == null) {
			return "redirect:/order/orderList";
		} else {
			model.addAttribute("review", selectReview);
			return "/review/reviewUpdateForm";
		}
	}
	
//	@PostMapping("/review/reviewUpdateForm")
//	public String form(@ModelAttribute Review review, HttpServletRequest req) throws Exception {
//		System.out.println(review.getReviewNo());
//		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
//		if (auth == null || auth.getGrant() < 1 || !auth.checkId((long) review.getMemberNo())) {
//			return "redirect:/member/noGrant";
//		}
//		return "/review/reviewUpdateForm";
//	}

	@PostMapping("/review/reviewUpdate")
	public String submit(Model model, @ModelAttribute Review review, @ModelAttribute("product") Product product,
			Errors errors) throws Exception {
		try {
			int productNo = review.getProductNo();
			Product product2 = reviewUpdateService.selectReviewRateByProductNo(productNo);
			reviewRateCal(review, product2);
			String con = review.getReviewContent();
			String sum = review.getReviewSummary();
			int rate = review.getReviewRate();
			if (rate >= 5) {
				review.setReviewRate(5);
				if (con == null && sum == null) 
					reviewUpdateService.updateReviewRate(review);
				else if (con == null && sum != null) 
					reviewUpdateService.updateReviewRateSummary(review);
				else if (con != null && sum == null) 
					reviewUpdateService.updateReviewRateContent(review);
				else 
					reviewUpdateService.updateReview(review);
			} else if (rate <= 1) {
				review.setReviewRate(1);
				if (con == null && sum == null) 
					reviewUpdateService.updateReviewRate(review);
				else if (con == null && sum != null) 
					reviewUpdateService.updateReviewRateSummary(review);
				else if (con != null && sum == null) 
					reviewUpdateService.updateReviewRateContent(review);
				else 
					reviewUpdateService.updateReview(review);
			} else {
				if (con == null && sum == null) 
					reviewUpdateService.updateReviewRate(review);
				else if (con == null && sum != null) 
					reviewUpdateService.updateReviewRateSummary(review);
				else if (con != null && sum == null) 
					reviewUpdateService.updateReviewRateContent(review);
				else 
					reviewUpdateService.updateReview(review);
		} }catch (WrongProductNoException | WrongOrderProductsNoException e) {
			System.out.println("wrongProductNo+wrongOrderProductsNo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/productDetailList?productNo=" + review.getProductNo();
	}

	public void reviewRateCal(Review review, @ModelAttribute("product") Product product) {
		try {
			int productNo = product.getProductNo();
			Product reviewRateByProductNo = reviewUpdateService.selectReviewRateByProductNo(productNo);

			int reviewProductNoCount = reviewUpdateService.selectReviewCountByProductNo(productNo);
			Optional<Integer> initial = Optional
					.ofNullable(Integer.parseInt(reviewRateByProductNo.getProductAvgRate()));
			if (initial.isPresent() != true) {
				String newReviewRate1 = Integer.toString(review.getReviewRate());
				reviewUpdateService.updateProductAvgRate(productNo, newReviewRate1);
			} else {
				int newReviewRate = (review.getReviewRate()
						+ Integer.parseInt(reviewRateByProductNo.getProductAvgRate()) * (reviewProductNoCount - 1))
						/ reviewProductNoCount;
				String newReviewRate1 = Integer.toString(newReviewRate);
				reviewUpdateService.updateProductAvgRate(productNo, newReviewRate1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
