package com.goupang.www.service.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.member.MemberDAO;
import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.member.RegisterRequest;
import com.goupang.www.exception.member.DuplicateMemberException;



@Service
@Transactional
public class MyPageService {
	
	@Autowired
	private MemberDAO memberDAO;

	public Member select(int memberNo) {
		List<Member> memberList = memberDAO.selectMemberByMemberNo(memberNo);
		
//		if (memberList.size() > 0 || !memberList.isEmpty()) {
//			
//		}
		return memberList.get(0);

		
	}

}


	


