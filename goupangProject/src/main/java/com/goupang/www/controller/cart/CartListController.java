package com.goupang.www.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.goupang.www.dto.cart.Cart;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.service.cart.CartListService;

@Controller
public class CartListController {
	@Autowired
	private CartListService cartListService;
	
	@RequestMapping("/cart/cartList")
	public String memberCart(Model model, HttpServletRequest req)throws Exception{
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		if(auth == null || auth.getGrant() < 1 ) {
			return "redirect:/member/noGrant";	
		}
		long memberNo = auth.getId();
		System.out.println("memberNo" + memberNo);
		List<Cart> cartList = cartListService.memberCartList(memberNo);
		model.addAttribute("cartList", cartList);
		System.out.println("cartList : " + cartList);
		return "/cart/cartList";
	}



	@RequestMapping("/cart/testcartList/{memberNo}")
	public String CartListByMemberNo(@PathVariable("memberNo") int memberNo, Model model, HttpServletRequest req)
			throws Exception {
		HttpSession session = req.getSession(false);

		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		long memberNo1 = auth.getId();
		System.out.println("memberNo" + memberNo);
		System.out.println("memberNo1" + memberNo1);

		List<Cart> cartList = cartListService.selectByMemberNo(memberNo);
		model.addAttribute("cartList", cartList);
		return "cart/testcartList";

	}



}
