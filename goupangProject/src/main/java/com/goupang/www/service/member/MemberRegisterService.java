package com.goupang.www.service.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.goupang.www.dao.member.MemberDAO;
import com.goupang.www.dto.manager.Manager;
import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.member.RegisterRequest;
import com.goupang.www.dto.seller.Seller;
import com.goupang.www.exception.member.DuplicateMemberException;



@Service
@Transactional
public class MemberRegisterService {
	
	@Autowired
	private MemberDAO memberDAO;

	public void regist(RegisterRequest req) {
		List<Member> email = memberDAO.selectMemberByEmail(req.getEmail());
		//이메일의 사이즈가 0보다 크거나 이메일이 비어있지 않거나
		if (email.size() > 0 || !email.isEmpty()) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		memberDAO.insertMember(req.getEmail(), req.getPassword(), req.getName(), req.getPhone());

		
	}
	public void registManager(Manager manager) {
		System.out.println(manager.getMANAGER_ID()+manager.getMANAGER_PW());
		String managerId = manager.getMANAGER_ID();
		List<Manager> managerList = memberDAO.selectManagerByManagerId(managerId);
		
		if (managerList.size() > 0 || !managerList.isEmpty()) {
			throw new DuplicateMemberException("dup email " +managerId);
		}
		memberDAO.insertManager(managerId, manager.getMANAGER_PW());
		
		
	}
	public void registSeller(Seller seller) {
		String sellerId = seller.getSellerId();
		//System.out.println("dddddddddd"+sellerId);
		List<Seller> sellerList = memberDAO.selectSellerBySellerId(sellerId);
//		System.out.println(seller.getSellerLicensenumber()+
//				seller.getSellerCompanyname()+
//				seller.getSellerName()+
//				sellerId+
//				seller.getSellerPw()+
//				seller.getSellerPhone()+
//				seller.getSellerAddr());
		//이메일의 사이즈가 0보다 크거나 이메일이 비어있지 않거나
		if (sellerList.size() > 0 || !sellerList.isEmpty()) {
			throw new DuplicateMemberException("dup email " + sellerId);
		}
		memberDAO.insertSeller(
				seller.getSellerLicensenumber(),
				seller.getSellerCompanyname(),
				seller.getSellerName(),
				sellerId,
				seller.getSellerPw(),
				seller.getSellerPhone(),
				seller.getSellerAddr()
				);
		
		
	}

}


	


