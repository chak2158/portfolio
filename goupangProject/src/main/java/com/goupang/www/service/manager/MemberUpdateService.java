package com.goupang.www.service.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.manager.ManagerDAO;
import com.goupang.www.dto.member.Member;


@Service
@Transactional
public class MemberUpdateService {
	
	@Autowired
	private ManagerDAO managerDAO;
	
public void updateMember(Member member) throws Exception {
	managerDAO.updateMember(member);
	}
}


	


