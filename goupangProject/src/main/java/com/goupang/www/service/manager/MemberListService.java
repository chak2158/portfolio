package com.goupang.www.service.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.manager.ManagerDAO;
import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.dto.member.Member;

@Service
@Transactional
public class MemberListService {

	@Autowired
	private ManagerDAO managerDAO;

	// 회원검색
	public List<Member> selectMemberList() throws Exception {
		return managerDAO.selectMemberList();
	}

	// 회원 이름검색
	public List<Member> selectByMemberName(String memberName) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>서비스까지옴");
		System.out.println("seller: " + memberName);
		return managerDAO.selectByMemberName(memberName);
	}

	// 멤버 수
	public int MemberCnt() {
		return managerDAO.MemberCnt();
	}
	//시작, 끝 페이지 리스트
	public List<Member> MemberList2(int startIndex, int pageSize) throws Exception {
		List<Member> memberList = managerDAO.MemberList2(startIndex, pageSize);
		return memberList;
	}

}
