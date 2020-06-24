package com.goupang.www.dao.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.review.Review;

public interface ReviewDAO {

	List<Review> selectReviewByOrderProductsNoList(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("orderProductsNo") int orderProductsNo) throws Exception;
	List<Review> selectReviewByProductNoList(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("productNo") int productNo) throws Exception;
	List<Review> selectReviewByMemberNoList(@Param("memberNo") int memberNo) throws Exception;
	Review selectReviewRateByMemberNo(@Param("memberNo") int memberNo) throws Exception; //memberNo로 reviewRate 간단 확인 위해 만듬
	Product selectReviewRateByProductNo(@Param("productNo") int productNo) throws Exception;
	Review selectReviewRateByProductNoMemberNo(@Param("memberNo") int memberNo, @Param("productNo") int productNo) throws Exception;
	int selectReviewCountByProductNo(int productNo);
	Review selectReviewNoByOrderStatusProductNo(@Param("orderStatus") int orderStatus, @Param("orderProductsNo") int orderProductsNo, @Param("productNo") int productNo) throws Exception;
	int selectReviewCountByOrderProductsNo(int orderProductsNo);
	int selectOrderStatusByProductNoOrderProductNo(@Param("productNo") int productNo, @Param("orderProductsNo") int orderProductsNo) throws Exception;
	Review selectReviewByReviewNo(@Param("reviewNo") int reviewNo) throws Exception;
	int selectReviewByOrderProductsNo(@Param("orderProductsNo") int orderProductsNo) throws Exception;
	
	void insertReview(
			@Param("orderProductsNo") int orderProductsNo,
			@Param("productNo") int productNo,
			@Param("reviewRate") int reviewRate,
			@Param("reviewContent") String reviewContent,
			@Param("reviewSummary") String reviewSummary
			)throws Exception;
	
	void insertReviewRate(
			@Param("orderProductsNo") int orderProductsNo,
			@Param("productNo") int productNo,
			@Param("reviewRate") int reviewRate
			)throws Exception;
	
	void insertReviewRateSummary(
			@Param("orderProductsNo") int orderProductsNo,
			@Param("productNo") int productNo,
			@Param("reviewRate") int reviewRate,
			@Param("reviewSummary") String reviewSummary
			)throws Exception;
	
	void insertReviewRateContent(
			@Param("orderProducstNo") int orderProductsNo,
			@Param("productNo") int productNo,
			@Param("reviewRate") int reviewRate,
			@Param("reviewContent") String reviewContent
			)throws Exception;
	
	void updateReview(
			@Param("reviewRate") int reviewRate,
			@Param("reviewNo") int reviewNo,
			@Param("reviewContent") String reviewContent,
			@Param("reviewSummary") String reviewSummary
			);
	
	void updateReviewRate(
			@Param("reviewRate") int reviewRate,
			@Param("reviewNo") int reviewNo
			);
	
	void updateReviewRateSummary(
			@Param("reviewRate") int reviewRate,
			@Param("reviewNo") int reviewNo,
			@Param("reviewSummary") String reviewSummary
			);
	
	void updateReviewRateContent(
			@Param("reviewRate") int reviewRate,
			@Param("reviewNo") int reviewNo,
			@Param("reviewContent") String reviewContent
			);
	
	void updateProductAvgRate(
			@Param("productNo") int productNo,
			@Param("productAvgRate") String productAvgRate
			);
	
	void deleteReview(@Param("reviewNo") int reviewNo) throws Exception;
}
