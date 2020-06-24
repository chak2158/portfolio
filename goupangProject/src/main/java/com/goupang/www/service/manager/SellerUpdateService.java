package com.goupang.www.service.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.manager.ManagerDAO;
import com.goupang.www.dto.seller.SellerRequest;


@Service
@Transactional
public class SellerUpdateService {
	
	@Autowired
	private ManagerDAO managerDAO;
	
public void updateSeller(SellerRequest selReq) throws Exception {
	System.out.println(">>>>>>>>>>>>>>>>>>> service: " + selReq.getSellerNo());
	managerDAO.updateSeller(selReq);
	}
}


	


