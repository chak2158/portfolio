package com.goupang.www.dto.seller;

public class SellerRequest {

	private String sellerGrant;
	private int sellerNo;

	public SellerRequest() {
	}
	
	public String getSellerGrant() {
		return sellerGrant;
	}

	public void setSellerGrant(String sellerGrant) {
		this.sellerGrant = sellerGrant;
	}
	
	public int getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}

	@Override
	public String toString() {
		return "SellerRequest [sellerGrant=" + sellerGrant + ", sellerNo=" + sellerNo + "]";
	}
	
	

}
