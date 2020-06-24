package com.goupang.www.service.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.cart.CartDAO;
import com.goupang.www.dto.cart.Cart;

@Service
@Transactional
public class CartUpdateService {

	@Autowired
	private CartDAO cartDAO;
	
	//장바구니 list에서의 수량 update
	public void updateCartQty(Cart cart) throws Exception {
		   cartDAO.updateCart(cart);
		   System.out.println("CartUpdateService - cart: " + cart);
		   }

	//장바구니 수량 업데이트
	public void updateCartQty(int cartNo,int orderQty) throws Exception {
		cartDAO.addQty(cartNo,orderQty);
	}
}
