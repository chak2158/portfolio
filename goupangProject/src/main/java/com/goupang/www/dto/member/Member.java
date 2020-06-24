package com.goupang.www.dto.member;

import com.goupang.www.exception.member.WrongIdPasswordException;


public class Member {
	int memberNo; /* 회원번호 */
	String memberEmail; /*NOT NULL, 회원EMAIL */
	String memberPw; /*NOT NULL, 회원PASSWORD */
	String memberName; /*NOT NULL, 회원이름 */
	String memberPhone; /*NOT NULL,회원PHONE */
	int memberGrant; /* 회원권한 */
	String memberAddr; /* 회원주소 */
	String memberLeaveDate; /* 회원탈퇴날자 */
	public Member() {}
	public Member(int memberNo, String memberEmail, String memberPw, String memberName, String memberPhone,
			int memberGrant, String memberAddr, String memberLeaveDate) {
		this.memberNo = memberNo;
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberGrant = memberGrant;
		this.memberAddr = memberAddr;
		this.memberLeaveDate = memberLeaveDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public int getMemberGrant() {
		return memberGrant;
	}
	public void setMemberGrant(int memberGrant) {
		this.memberGrant = memberGrant;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberLeaveDate() {
		return memberLeaveDate;
	}
	public void setMemberLeaveDate(String memberLeaveDate) {
		this.memberLeaveDate = memberLeaveDate;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!memberPw.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.memberPw = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.memberPw.equals(password);
	}
	
}
