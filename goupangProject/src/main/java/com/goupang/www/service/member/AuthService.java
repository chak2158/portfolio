package com.goupang.www.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.member.MemberDAO;
import com.goupang.www.dto.manager.Manager;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.seller.Seller;
import com.goupang.www.exception.member.WrongIdPasswordException;

@Service
@Transactional
public class AuthService {
	
	@Autowired
	private MemberDAO memberDAO;

	public AuthInfo authenticate(String email, String password) {
		//System.out.println("dd:"+email+","+password);
		List<Member> memberList = memberDAO.selectMemberByEmail(email);
		if (memberList.size() == 0) {
			throw new WrongIdPasswordException();
		}
		//System.out.println("size:"+memberList.size());
		Member member = memberList.get(0);
		if (member == null) {
			
			throw new WrongIdPasswordException();
		}
		//System.out.println("pw:"+member.getMemberPw());
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(
			(long) member.getMemberNo(),
			member.getMemberEmail(),
			member.getMemberName(),
			member.getMemberGrant()
			);
		
	}
	
	public AuthInfo managerAuthenticate(String id, String pw) {
		//System.out.println("dd:"+email+","+password);
		List<Manager> managerList = memberDAO.selectManagerByManagerId(id);
		if (managerList.size() == 0) {
			throw new WrongIdPasswordException();
		}
		//System.out.println("size:"+memberList.size());
		Manager manager = managerList.get(0);
		if (manager == null) {
			
			throw new WrongIdPasswordException();
		}
		//System.out.println("pw:"+member.getMemberPw());
		if (!manager.getMANAGER_PW().equals(pw)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(
			(long) manager.getMANAGER_NO(),
			manager.getMANAGER_ID(),
			manager.getMANAGER_ID(),
			manager.getMANAGER_NO()
			);
		
	}
	
	public AuthInfo sellerAuthenticate(String id, String pw) {
		//System.out.println("dd:"+email+","+password);
		List<Seller> sellerList = memberDAO.selectSellerBySellerId(id);
		if (sellerList.size() == 0) {
			throw new WrongIdPasswordException();
		}
		//System.out.println("size:"+memberList.size());
		Seller seller = sellerList.get(0);
		if (seller == null) {
			
			throw new WrongIdPasswordException();
		}
		//System.out.println("pw:"+member.getMemberPw());
		if (!seller.getSellerPw().equals(pw)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(
			(long) seller.getSellerNo(),
			seller.getSellerId(),
			seller.getSellerName(),
			Integer.parseInt(seller.getSellerGrant())
			);
	}

}
