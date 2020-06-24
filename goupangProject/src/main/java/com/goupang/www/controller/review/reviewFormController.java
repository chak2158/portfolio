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
import com.goupang.www.dto.review.ReviewRequest;
import com.goupang.www.exception.review.WrongOrderProductsNoException;
import com.goupang.www.exception.review.WrongProductNoException;
import com.goupang.www.service.product.ProductListService;
import com.goupang.www.service.review.ReviewFormService;

@Controller
public class reviewFormController {

	@Autowired
	private ReviewFormService reviewFormService;
	@Autowired
	private ProductListService productListService;

	@GetMapping("/review/reviewForm")
	public String form(Model model, HttpServletRequest req, @RequestParam("productNo") int productNo,
			@RequestParam("orderProductsNo") int orderProductsNo) throws Exception {
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		if (auth == null || auth.getGrant() < 1) {
			return "redirect:/member/noGrant";
		}
		Optional<Integer> orderState = Optional
				.ofNullable(reviewFormService.selectOrderStatusByProductNoOrderProductNo(orderProductsNo, productNo));
//		Optional<Integer> orderProductsNoSel = Optional.ofNullable(
//				reviewFormService.selectReviewByOrderProductsNo(orderProductsNo));
		if (orderState.isPresent() == false) {
			return "redirect:/order/orderList";
//		}else if(orderProductsNoSel.isPresent() == true) {
//			return "redirect:/order/orderList";
		}else {
			int orderStatus = reviewFormService.selectOrderStatusByProductNoOrderProductNo(orderProductsNo, productNo);
			Review reviewSelect = reviewFormService.selectReviewNoByOrderStatusProductNo(orderStatus, orderProductsNo,
					productNo);
			if (reviewSelect != null || orderStatus != 3) {
				return "redirect:/product/productDetailList?productNo=" + productNo;
			} else if (reviewSelect == null && orderStatus == 3) {
				ReviewRequest reviewReq = new ReviewRequest();
				reviewReq.setMemberNo(auth.getId().intValue());
				reviewReq.setMemberName(auth.getName());
				reviewReq.setProductNo(productNo);
				reviewReq
						.setProductName(productListService.selectProductByProductNo(productNo).get(0).getProductName());
				reviewReq.setOrderProductsNo(orderProductsNo);
				reviewReq.setOrderStatus(orderStatus);
				reviewReq.setProductOption(
						productListService.selectProductByProductNo(productNo).get(0).getProductOption());
				model.addAttribute("reviewRequest", reviewReq);
				return "/review/reviewForm";
			} else {
				return "redirect:/product/productDetailList?productNo=" + productNo;
			}
		}
	}

	@PostMapping("/review/reviewForm")
	public String submit(ReviewRequest reviewReq, Errors errors, @ModelAttribute("product") Product product,
			@ModelAttribute Review review, Model model, @RequestParam int productNo) {

		try {
			Product product2 = reviewFormService.selectReviewRateByProductNo(productNo);
			reviewRateCal(reviewReq, product2, productNo);
			String con = reviewReq.getReviewContent();
			String sum = reviewReq.getReviewSummary();
			int rate = reviewReq.getReviewRate();
			if (rate >= 5) {
				reviewReq.setReviewRate(5);
				 	if (con == null && sum == null) 
						reviewFormService.insertReviewRate(reviewReq);
					else if (con == null && sum != null) 
						reviewFormService.insertReviewRateSummary(reviewReq);
					else if (con != null && sum == null) 
						reviewFormService.insertReviewRateContent(reviewReq);
					else 
						reviewFormService.insertReview(reviewReq);
			} else if (rate <= 1) {
				reviewReq.setReviewRate(1);
				 	if (con == null && sum == null) 
						reviewFormService.insertReviewRate(reviewReq);
					else if (con == null && sum != null) 
						reviewFormService.insertReviewRateSummary(reviewReq);
					else if (con != null && sum == null) 
						reviewFormService.insertReviewRateContent(reviewReq);
					else 
						reviewFormService.insertReview(reviewReq);
			} else {
					if (con == null && sum == null) 
						reviewFormService.insertReviewRate(reviewReq);
					else if (con == null && sum != null) 
						reviewFormService.insertReviewRateSummary(reviewReq);
					else if (con != null && sum == null) 
						reviewFormService.insertReviewRateContent(reviewReq);
					else 
						reviewFormService.insertReview(reviewReq);
		} }catch (WrongProductNoException | WrongOrderProductsNoException e) {
			System.out.println("wrongProductNo+wrongOrderProductsNo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/productDetailList?productNo=" + productNo;
	}

	public void reviewRateCal(ReviewRequest reviewReq, @ModelAttribute("product") Product product,
			@RequestParam int productNo) {
		try {

			Product reviewRateByProductNo = reviewFormService.selectReviewRateByProductNo(productNo);
			int reviewProductNoCount = reviewFormService.selectReviewCountByProductNo(productNo);

			Optional<Integer> initial = Optional
					.ofNullable(Integer.parseInt(reviewRateByProductNo.getProductAvgRate()));

			if (initial.isPresent() != true) {
				String newReviewRate1 = Integer.toString(reviewReq.getReviewRate());
				reviewFormService.updateProductAvgRate(productNo, newReviewRate1);
			} else {
				int newReviewRate = (reviewReq.getReviewRate()
						+ Integer.parseInt(reviewRateByProductNo.getProductAvgRate()) * (reviewProductNoCount - 1))
						/ reviewProductNoCount;
				String newReviewRate1 = Integer.toString(newReviewRate);
				reviewFormService.updateProductAvgRate(productNo, newReviewRate1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
