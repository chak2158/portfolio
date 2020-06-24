package com.goupang.www.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.order.Order;
import com.goupang.www.service.order.OrderListService;

@Controller
public class OrderListController {
	
	@Autowired
	private OrderListService orderListService;

	//@ResponseBody
	@RequestMapping("/order/orderList")
	public String OrderList(Model model,HttpServletRequest req) throws Exception {
		System.out.println("컨트롤러까지왔찌");
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		long memberNo=auth.getId();
		System.out.println("memberNo" + memberNo);
		
		List<Order> orderList = orderListService.orderListAll(memberNo);
		System.out.println("OrderListContoller");
		model.addAttribute("orderList", orderList);
		System.out.println(orderList);
		return "/order/orderList";
	}

//	@RequestMapping("/cart/testOrderList/{member_no}")
//	public String OrderListByMemberNo(@PathVariable("member_no") int member_no, Model model) throws Exception {
//		List<Order> orderList = orderListService.selectByMemberNo(member_no);
//		model.addAttribute("orderList", orderList);
//		return "order/testOrderList";
//
//	}


}
