package com.goupang.www.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.review.ReviewDAO;
import com.goupang.www.dto.review.Review;

@Service
@Transactional
public class ReviewListService {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public List<Review> selectReviewByOrderProductsNoList(int startIndex, int pageSize, int orderProductsNo) throws Exception{		
		return reviewDAO.selectReviewByOrderProductsNoList(startIndex, pageSize, orderProductsNo);
	}
	
	public List<Review> selectReviewByProductNoList(int startIndex, int pageSize, int productNo) throws Exception{		
		return reviewDAO.selectReviewByProductNoList(startIndex, pageSize, productNo);
	}
	
	public List<Review> selectReviewByMemberNoList(int memberNo) throws Exception{
		return reviewDAO.selectReviewByMemberNoList(memberNo);
	}
	
	public int selectReviewCountByProductNo(int productNo) {
		return reviewDAO.selectReviewCountByProductNo(productNo);
	}
	
	public int selectReviewCountByOrderProductsNo(int orderProductsNo) {
		return reviewDAO.selectReviewCountByOrderProductsNo(orderProductsNo);
	}
}
