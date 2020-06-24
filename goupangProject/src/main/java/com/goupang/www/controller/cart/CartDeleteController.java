package com.goupang.www.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.goupang.www.dto.cart.Cart;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.service.cart.CartDeleteService;
import com.goupang.www.service.cart.CartListService;

@Controller
public class CartDeleteController {

	@Autowired
	private CartDeleteService cartDeleteService;

	@Autowired
	private CartListService cartListService;

	@GetMapping("/cart/deleteCartList")
	public String delete(Model model, @ModelAttribute Cart cart, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		long member = auth.getId();
		
		System.out.println(req.getParameter("cartNo"));
		System.out.println(req.getParameter("memberNo"));
		
		int cartNo = Integer.parseInt(req.getParameter("cartNo"));
		long memberNo = Integer.parseInt(req.getParameter("memberNo"));
		
		if(member==memberNo) {
		System.out.println("deleteCart " + cart);
		System.out.println("CartDeleteController");
		System.out.println("cartNo : " + cartNo + ", memberNo : " + memberNo);
		String error = cartDeleteService.deleteCart(cartNo);
		List<Cart> cartList = cartListService.memberCartList(memberNo);
		model.addAttribute("cartList", cartList);
		model.addAttribute("error", error);
		}
		else return " ";
		return "cart/cartList";
	}

	@ResponseBody
	@RequestMapping(value = "/cart/deleteCheckCart", method = RequestMethod.POST)
	public int deleteCart(HttpServletRequest req, @RequestParam(value = "chbox[]") List<String> chArr, Cart cart)
			throws Exception {
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		long memberNo = auth.getId();
		System.out.println("memberNo : " + memberNo);
		int cartNo = 0;
		int result = 0;
		System.out.println("chbox[] : " + chArr);
		if (memberNo != 0) {
			cart.setCartNo(cartNo);
			
			for (String i : chArr) {
				cartNo = Integer.parseInt(i);
				System.out.println("cartNo[] : " + cartNo);
				cart.setCartNo(cartNo);
				cartDeleteService.deleteCart(cartNo);
			}
			result = 1;
		}
		return result;
		
	}
}
