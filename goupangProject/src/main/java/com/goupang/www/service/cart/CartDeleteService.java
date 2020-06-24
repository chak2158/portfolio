package com.goupang.www.service.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goupang.www.dao.cart.CartDAO;
import com.goupang.www.dto.order.OrderCommand;

@Service
@Transactional
public class CartDeleteService {
	
	@Autowired
	private CartDAO cartDAO;
	
	public String deleteCart(int cartNo) {
		try {
			System.out.println("cartNo:"+cartNo);
			cartDAO.deleteCart(cartNo);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "회원의 장바구니가 없슴다";
		}
		
	}
	
//	public List<Product> cartNoInfo(int cartNo) throws Exception{
//		return cartDAO.cartNoInfo(cartNo);
//	}

	public Map<String, OrderCommand> selectProductListByCartNo(List<String> chArr) {
		
		Map<String, OrderCommand> map = new HashMap<String, OrderCommand>();
		for(String i : chArr) {
			
			map.put(i, cartDAO.selectCartByCartNo(Integer.parseInt(i)));
			
		}
			//cart.setCartNo(cartNo);
		//List<Product> list 
//			for (String i : chArr) {
//				int cartNo = Integer.parseInt(i);
//				//System.out.println("cartNo[] : " + cartNo);
//				cart.setCartNo(cartNo);
//				product.add(cartDeleteService.cartNoInfo(cartNo).get(0));
//				//cartDeleteService.deleteCart(cartNo);
//				//System.out.println("product :" + product);
//				
			
		return map;
	}
}
