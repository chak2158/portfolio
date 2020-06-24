package com.goupang.www.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.review.ReviewDAO;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.review.Review;
import com.goupang.www.dto.review.ReviewUpdate;

@Service
@Transactional
public class ReviewUpdateService {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public int selectReviewCountByProductNo(int productNo) throws Exception {
		return reviewDAO.selectReviewCountByProductNo(productNo);
	}
	public void updateProductAvgRate(int productNo, String productAvgRate) throws Exception{
		reviewDAO.updateProductAvgRate(productNo, productAvgRate);
	}
	public Product selectReviewRateByProductNo(int productNo) throws Exception {
		return reviewDAO.selectReviewRateByProductNo(productNo);
	}
	public Review selectReviewByReviewNo(int reviewNo) throws Exception {
		return reviewDAO.selectReviewByReviewNo(reviewNo);
	}
	
	public void updateReview(Review review) throws Exception {
		reviewDAO.updateReview(
				review.getReviewNo(),
				review.getReviewRate(),
				review.getReviewContent(),
				review.getReviewSummary()
				);
	}
	
	public void updateReviewRate(Review review) throws Exception {
		reviewDAO.updateReviewRate(
				review.getReviewNo(), 
				review.getReviewRate()
				);
	}
	
	public void updateReviewRateSummary(Review review) throws Exception {
		reviewDAO.updateReviewRateSummary(
				review.getReviewNo(), 
				review.getReviewRate(), 
				review.getReviewSummary()
				);
	}
	
	public void updateReviewRateContent(Review review) throws Exception {
		reviewDAO.updateReviewRateContent(
				review.getReviewNo(), 
				review.getReviewRate(), 
				review.getReviewContent()
				);
	}
	
	public ReviewUpdate selectReviewByMemberNoList(int memberNo, int orderStatus) throws Exception {
//		int listCnt = reviewListService.selectReviewCountByProductNo(productNo);	
//		Pagination pagination = new Pagination(listCnt, curPage);
		List<Review> reviewList = reviewDAO.selectReviewByMemberNoList(memberNo);
		Review review = reviewList.get(memberNo);
		
		return null;
	}
	
}
