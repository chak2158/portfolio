package com.goupang.www.dto.review;

public class UploadVO {

	private int rateImgNo;
	private int reviewNo;
	private String rateImgPath;
	private String rateThumbPath;
	
	public int getRateImgNo() {
		return rateImgNo;
	}
	public void setRateImgNo(int rateImgNo) {
		this.rateImgNo = rateImgNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getRateImgPath() {
		return rateImgPath;
	}
	public void setRateImgPath(String rateImgPath) {
		this.rateImgPath = rateImgPath;
	}
	public String getRateThumbPath() {
		return rateThumbPath;
	}
	public void setRateThumbPath(String rateThumbPath) {
		this.rateThumbPath = rateThumbPath;
	}
	
	@Override
	public String toString() {
		return "ReviewImage [rateImgNo=" + rateImgNo + ", reviewNo=" + reviewNo + ", rateImgPath=" + rateImgPath
				+ ", rateThumbPath=" + rateThumbPath + "]";
	}
	
}
