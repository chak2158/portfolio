package com.goupang.www.controller.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.order.Order;
import com.goupang.www.dto.order.OrderCommand;
import com.goupang.www.dto.order.OrderRequest;
import com.goupang.www.service.cart.CartDeleteService;
import com.goupang.www.service.order.OrderFormService;

@Controller
public class OrderFormController {

	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private CartDeleteService cartDeleteService;

	@RequestMapping("/order/orderPage")
	public String orderForm(Model model, @RequestParam("data") String data, HttpServletRequest req) throws Exception {
		System.out.println("data >>>>>>>>>>>>>>>>>>>>>>>>>" + data);
		Map<String, Object> orderCommand = new HashMap<String, Object>();
		try {
			System.out.println("-------------------JSON String 을 MAP 으로 변환-----------------------");
			ObjectMapper mapper = new ObjectMapper();

			orderCommand = mapper.readValue(data, new TypeReference<Map<String, Object>>() {
			});
			// System.out.println(orderCommand);
			// System.out.println(map.get("name"));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("orderCommand >>>>>>>>>>>>>>> " + orderCommand);
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		System.out.println("auth : " + auth.getEmail());
//		Long memberNo = Long.parseLong(req.getParameter("memberNo"));
//		System.out.println("memberNo : " + memberNo);
		// List<Member> orderMember = orderFormService.memberInfo(memberNo);
		model.addAttribute("orderCommand", orderCommand);
		return "/order/orderPage";
	}

//	@GetMapping("/order/modifyPhone")
//	public String modify(Model model, @ModelAttribute Member member, HttpServletRequest req) throws Exception{
//		HttpSession session = req.getSession(false);
//		Object authInfo = session.getAttribute("authInfo");
//		AuthInfo auth = (AuthInfo) authInfo;
//		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
//		String error = orderFormService.modifyPhone(memberNo);
//		return "order/modifyPhone";
//	
//	}

	@ResponseBody
	@RequestMapping(value = "/order/orderPage", method = RequestMethod.POST)
	// @PostMapping("order/orderPage")
	public Map<String, OrderCommand> order(Model model, HttpServletRequest req,
			@RequestParam(value = "chbox[]") List<String> chArr) throws Exception {
		System.out.println("chArr" + chArr);
		// List<Product> product = new ArrayList<Product>();
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		
		long memberNo = auth.getId();
		// List<>

		if (memberNo != 0) {
			Map<String, OrderCommand> orderCommand = cartDeleteService.selectProductListByCartNo(chArr);
			// 맵에 담긴 값을 뽑아봄
//			for(String i : chArr) {
//				System.out.println(i + " : " + productList.get(i));
//			}
			System.out.println("orderCommand : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + orderCommand);
			model.addAttribute("orderCommand", orderCommand);

			return orderCommand;
		}

		return null;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/order/orderForm", method = RequestMethod.POST)
	public int form(Model model, HttpServletRequest req, @RequestBody Map<String, Object> params) throws Exception {
		//orderPage에서 ajax로 넘긴 데이터를 서비스로 넘김
		int result = orderFormService.insertOrderProduct(params);
		System.out.println("파람파람:" + params);
		//model.addAttribute(order);
		return result;
	}
	
	@RequestMapping(value = "/order/orderSuccess", method = RequestMethod.GET)
	public String orderSuccess(Model model,HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		Object authInfo = session.getAttribute("authInfo");
		AuthInfo auth = (AuthInfo) authInfo;
		
		System.out.println("auth: " + auth);
		model.addAttribute("auth",auth);
		return "/order/orderSuccess";
	}
	
	
}
