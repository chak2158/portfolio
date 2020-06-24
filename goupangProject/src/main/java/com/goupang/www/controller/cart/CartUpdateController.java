package com.goupang.www.controller.cart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.goupang.www.dto.cart.Cart;
import com.goupang.www.service.cart.CartListService;
import com.goupang.www.service.cart.CartUpdateService;
@Controller
public class CartUpdateController {
	
	@Autowired
	private CartUpdateService cartUpdateService;
	@Autowired
	private CartListService cartListService;
	
	@PostMapping("/cart/updateCartList")
	public String updateCartList(Model model, @ModelAttribute("cart") Cart cart) throws Exception{
		System.out.println("cart(updateCartList) : " + cart.toString());
		cartUpdateService.updateCartQty(cart);
		long memberNo=cart.getMemberNo();
		List<Cart> cartList = cartListService.memberCartList(memberNo);
		model.addAttribute("cartList",cartList);
		return "/cart/cartList";
	}
}
