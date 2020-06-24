package com.goupang.www.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goupang.www.dto.cart.Cart;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.service.cart.CartFormService;
import com.goupang.www.service.cart.CartListService;
import com.goupang.www.service.cart.CartUpdateService;

@Controller
public class CartFormController {

	@Autowired
	private CartListService cartListService;
	@Autowired
	private CartUpdateService cartUpdateService;
	@Autowired
	private CartFormService cartFormService;

//	@GetMapping("/cart/addCartAjax")
//	@ResponseBody
	@GetMapping("/cart/addCart")
	public String addCartForm(Model model, HttpServletRequest req, Cart cart,@RequestParam("productNo") int productNo,@RequestParam("orderQty")int orderQty) throws Exception {
		System.out.println("addCartController");
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		if(auth == null || auth.getGrant() < 1 ) {
			return "redirect:/member/noGrant";	
		}
		int memberNo = auth.getId().intValue();
		System.out.println("memberNo:" + memberNo + "productNo:" + productNo + "orderQty:" + orderQty);
		cart.setMemberNo(memberNo);
		// System.out.println("cart" + cart);

		// 기존 장바구니에 상품이 있는지 검사
		List<Integer> result = cartListService.checkMemberHasCart(cart);
		System.out.println("result :" + result);
		// 없으면 insert
		if (result==null||result.isEmpty()) {
			cart.setMemberNo(memberNo);
			cartFormService.addCart(memberNo, productNo, orderQty);
			System.out.println("cart" + cart);
			
		// 있으면 업데이트
		} else {
			cart.setCartNo(result.get(0));
			int beforeQty = cartListService.cartQty(result.get(0));
			// System.out.println("cartNo=" + cartNo + "beforeQty=" + beforeQty)
			System.out.println("cart" + cart);
			//cart.setCartNo(cartNo);
			int newQty = orderQty + beforeQty;
			cart.setOrderQty(newQty);
			cartUpdateService.updateCartQty(cart);
		}
		List<Cart> cartList = cartListService.memberCartList(memberNo);
		model.addAttribute("cartList", cartList);
		return "/cart/cartList";

	}

//	@PostMapping("/cart/addCart")
//	public String addCart(Model model, Cart cart, HttpServletRequest req) throws Exception {
//		HttpSession session = req.getSession(false);
//		Object authInfo = session.getAttribute("authInfo");
//		AuthInfo auth = (AuthInfo) authInfo;
//		long memberNo = auth.getId();
//		cartFormService.insertCart(cart);
//		List<Cart> cartList = cartListService.memberCartList(memberNo);
//		model.addAttribute("cartList", cartList);
//		System.out.println("cartList" + cartList);
//		return "/cart/cartList";
//
//	}

}
