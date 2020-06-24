package com.goupang.www.service.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.manager.ManagerDAO;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.seller.Seller;

@Service
@Transactional
public class SellerListService {
	
	@Autowired
	private ManagerDAO managerDAO;
	
		
	public List<Seller> selectSellerList() throws Exception {
		return managerDAO.selectSellerList();
	}
	
	public List<Product> selectBySellerNo(int seller) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>서비스까지옴");
		System.out.println("seller: " +seller);
	      return managerDAO.selectBySellerNo(seller);
	   } 

	
	
}
