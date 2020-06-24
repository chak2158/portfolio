package com.goupang.www.service.cart;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.goupang.www.dao.cart.CartDAO;
import com.goupang.www.dto.cart.Cart;


@Service
@Transactional
public class CartListService {
	
	@Autowired
	private CartDAO cartDAO;
	
	public List<Cart> memberCartList(long memberNo) throws Exception {
		System.out.println("CartListService");
		return cartDAO.memberCartList(memberNo);
	}

	
	public List<Cart> cartListAll() throws Exception {
		System.out.println("CartListService");
		return cartDAO.selectAllCartList();
	}

	public List<Cart> selectByMemberNo(int member_no) throws Exception {
		return cartDAO.selectByMemberNo(member_no);
	}
	
	//기존 장바구니 체크
	public List<Integer> checkMemberHasCart(Cart cart) throws Exception{
		System.out.println("Service :cartNo = " + cart );
		return cartDAO.checkMemberHasCart(cart);
	}


	//장바구니 수량 가져오기
	public int cartQty(int cartNo) throws Exception {
		System.out.println("Service :cartNo = " + cartNo);
		return cartDAO.cartQty(cartNo);
	}



}
