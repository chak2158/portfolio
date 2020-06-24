package com.goupang.www.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.review.ReviewDAO;

@Service
@Transactional
public class ReviewDeleteService {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public String deleteReview(int reviewNo) {
		try {
			reviewDAO.deleteReview(reviewNo);
			return null;
		} catch (Exception e) {
			return "삭제가 되지 않았습니다";
		}
	}
}
