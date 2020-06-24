package com.goupang.www.dto.seller;

public class Seller {
	private int sellerNo;  /*NOT NULL, 판매자번호 */
	private int sellerLicensenumber;  /*NOT NULL, 사업자번호 */
	private String sellerCompanyname;  /*NOT NULL, 상호 */
	private String sellerName;  /*NOT NULL, 대표자 */
	private String sellerId;  /*NOT NULL, 판매자ID */
	private String sellerPw;  /*NOT NULL, 판매자PASSWORD */
	private String sellerPhone;  /*NOT NULL, 판매자PHONE */
	private String sellerAddr;  /*NOT NULL, 판매자ADDR */
	private String sellerGrant;  /* 승인여부 */
	
	public Seller() {
	}
	
	public Seller(int sellerNo, int sellerLicensenumber, String sellerCompanyname, String sellerName, String sellerId,
			String sellerPw, String sellerPhone, String sellerAddr, String sellerGrant) {
		super();
		this.sellerNo = sellerNo;
		this.sellerLicensenumber = sellerLicensenumber;
		this.sellerCompanyname = sellerCompanyname;
		this.sellerName = sellerName;
		this.sellerId = sellerId;
		this.sellerPw = sellerPw;
		this.sellerPhone = sellerPhone;
		this.sellerAddr = sellerAddr;
		this.sellerGrant = sellerGrant;
	}
	public int getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}
	public int getSellerLicensenumber() {
		return sellerLicensenumber;
	}
	public void setSellerLicensenumber(int sellerLicensenumber) {
		this.sellerLicensenumber = sellerLicensenumber;
	}
	public String getSellerCompanyname() {
		return sellerCompanyname;
	}
	public void setSellerCompanyname(String sellerCompanyname) {
		this.sellerCompanyname = sellerCompanyname;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerPw() {
		return sellerPw;
	}
	public void setSellerPw(String sellerPw) {
		this.sellerPw = sellerPw;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getSellerAddr() {
		return sellerAddr;
	}
	public void setSellerAddr(String sellerAddr) {
		this.sellerAddr = sellerAddr;
	}
	public String getSellerGrant() {
		return sellerGrant;
	}
	public void setSellerGrant(String sellerGrant) {
		this.sellerGrant = sellerGrant;
	}
	
	@Override
	public String toString() {
		return "Seller [sellerNo=" + sellerNo + ", sellerLicensenumber=" + sellerLicensenumber + ", sellerCompanyname="
				+ sellerCompanyname + ", sellerName=" + sellerName + ", sellerId=" + sellerId + ", sellerPw=" + sellerPw
				+ ", sellerPhone=" + sellerPhone + ", sellerAddr=" + sellerAddr + ", sellerGrant=" + sellerGrant + "]";
	}
	
	
	
	
}
