package com.goupang.www.service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goupang.www.dao.cart.CartDAO;
import com.goupang.www.dto.cart.Cart;


@Service
@Transactional
public class CartFormService {
	
	@Autowired
	private CartDAO cartDAO;

	//장바구니 추가
	public int addCart(int memberNo, int productNo, int orderQty) throws Exception {
		return cartDAO.addNewCart(memberNo,productNo,orderQty);
		
	}
	
	

}
