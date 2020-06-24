package com.goupang.www.service.review;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.review.ReviewDAO;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.review.Review;
import com.goupang.www.dto.review.ReviewRequest;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ReviewFormService {
	@Autowired
	private ReviewDAO reviewDAO;
	public Review selectReviewRateByMemberNo(int memberNo) throws Exception{
		return reviewDAO.selectReviewRateByMemberNo(memberNo);
	}
	public Product selectReviewRateByProductNo(int productNo) throws Exception {
		return reviewDAO.selectReviewRateByProductNo(productNo);
	}
	public Review selectReviewRateByProductNoMemberNo(int memberNo, int productNo) throws Exception {
		return reviewDAO.selectReviewRateByProductNoMemberNo(memberNo, productNo);
	}
	public int selectReviewCountByProductNo(int productNo) throws Exception {
		return reviewDAO.selectReviewCountByProductNo(productNo);
	}
	public int selectReviewCountByOrderProductsNo(int orderProductsNo) throws Exception{
		return reviewDAO.selectReviewCountByOrderProductsNo(orderProductsNo);
	}
	public void updateProductAvgRate(int productNo, String productAvgRate) throws Exception{
		reviewDAO.updateProductAvgRate(productNo, productAvgRate);
	}
	public Review selectReviewNoByOrderStatusProductNo(int orderStatus, int orderProductsNo, int productNo) throws Exception{
		return reviewDAO.selectReviewNoByOrderStatusProductNo(orderStatus, orderProductsNo, productNo);
	}
	public int selectOrderStatusByProductNoOrderProductNo(int orderProductsNo, int productNo) throws Exception{
		return reviewDAO.selectOrderStatusByProductNoOrderProductNo(productNo, orderProductsNo);
	}
	public int selectReviewByOrderProductsNo(int orderProductsNo) throws Exception{
		return reviewDAO.selectReviewByOrderProductsNo(orderProductsNo);
	}
	
	public void insertReview(ReviewRequest reviewReq) throws Exception {
		reviewDAO.insertReview(
				reviewReq.getOrderProductsNo(),
				reviewReq.getProductNo(),
				reviewReq.getReviewRate(),
				reviewReq.getReviewContent(),
				reviewReq.getReviewSummary()
				);
	}
	
	public void insertReviewRate(ReviewRequest reviewReq) throws Exception {
		reviewDAO.insertReviewRate(
				reviewReq.getOrderProductsNo(), 
				reviewReq.getProductNo(),
				reviewReq.getReviewRate()
				);
	}
	
	public void insertReviewRateSummary(ReviewRequest reviewReq) throws Exception {
		reviewDAO.insertReviewRateSummary(
				reviewReq.getOrderProductsNo(), 
				reviewReq.getProductNo(), 
				reviewReq.getReviewRate(), 
				reviewReq.getReviewSummary()
				);
	}
	
	public void insertReviewRateContent(ReviewRequest reviewReq) throws Exception {
		reviewDAO.insertReviewRateContent(
				reviewReq.getOrderProductsNo(), 
				reviewReq.getProductNo(), 
				reviewReq.getReviewRate(), 
				reviewReq.getReviewContent()
				);
	}
	
	
}
