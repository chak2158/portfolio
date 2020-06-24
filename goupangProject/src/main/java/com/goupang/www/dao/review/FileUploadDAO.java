package com.goupang.www.dao.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.review.ReviewImage;

public interface FileUploadDAO {
	
	List<ReviewImage> selectImg(@Param("reviewNo") int reviewNo) throws Exception;
	
	void insertImage(
			@Param("reviewNo") int reviewNo,
			@Param("rateImgPath") String rateImgPath,
			@Param("rateThumbPath") String rateThumbPath
			);
	
	void updateImage(
			@Param("reviewNo") int reviewNo,
			@Param("rateImgPath") String rateImgPath,
			@Param("rateThumbPath") String rateThumbPath
			);
	
}
