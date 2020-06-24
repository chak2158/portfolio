package com.goupang.www.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.order.Order;
import com.goupang.www.service.order.OrderListService;
import com.goupang.www.service.order.UpdateOrderService;

@Controller
public class UpdateOrderController {
	@Autowired
	private UpdateOrderService updateOrderService;
	@Autowired
	private OrderListService orderListService;
	
	@GetMapping("/order/confirmOrderUpdate")
	public String updateConfirm(Model model, @ModelAttribute("order") Order order, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		long memberNo = auth.getId();
		System.out.println("memberNo" + memberNo);		
		int orderProductsNo = Integer.parseInt(req.getParameter("orderProductsNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		System.out.println("order" + order);
		System.out.println("orderProductsNo : " +orderProductsNo + ", productNo : " + productNo);
		updateOrderService.confirmOrder(order);
		List<Order> orderList = orderListService.orderListAll(memberNo);
		System.out.println("orderList : " + orderList);
		model.addAttribute("orderList", orderList);
		return "/order/orderList";
		
	}
	@GetMapping("/order/refundOrderUpdate")
	public String updateRefund(Model model, @ModelAttribute("order") Order order, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		long memberNo = auth.getId();
		System.out.println("memberNo" + memberNo);
		int orderProductsNo = Integer.parseInt(req.getParameter("orderProductsNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		System.out.println("order" + order);
		System.out.println("orderProductsNo : " +orderProductsNo + ", productNo : " + productNo);
		updateOrderService.refundOrder(order);
		List<Order> orderList = orderListService.orderListAll(memberNo);
		model.addAttribute("orderList", orderList);
		return "/order/orderList";
		
	}
	@GetMapping("/order/cancelOrderUpdate")
	public String updateCancel(Model model, @ModelAttribute("order") Order order, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		long memberNo = auth.getId();
		System.out.println("memberNo" + memberNo);
		int orderProductsNo = Integer.parseInt(req.getParameter("orderProductsNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		System.out.println("order" + order);
		System.out.println("orderProductsNo : " +orderProductsNo + ", productNo : " + productNo);
		updateOrderService.cancelOrder(order);
		List<Order> orderList = orderListService.orderListAll(memberNo);
		model.addAttribute("orderList", orderList);
		return "/order/orderList";
		
	}
}
