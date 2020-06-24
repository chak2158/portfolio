package com.goupang.www.service.manager;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.manager.ManagerDAO;


@Service
@Transactional
public class MemberDeleteService {
	
	@Autowired
	private ManagerDAO managerDAO;

	public String deleteMember(int memberNo) {
		try {
			managerDAO.deleteMember(memberNo);
			return null;
		} catch (Exception e) {
			return "삭제할 수 없습니다. 다시 시도해보십시오.";
		}
	}

	
	
}


	


