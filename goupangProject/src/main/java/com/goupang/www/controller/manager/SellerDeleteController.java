package com.goupang.www.controller.manager;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goupang.www.dto.seller.Seller;
import com.goupang.www.dto.seller.SellerRequest;
import com.goupang.www.service.manager.SellerDeleteService;
import com.goupang.www.service.manager.SellerListService;


@Controller
public class SellerDeleteController {
	@Autowired
	private SellerDeleteService sellerDeleteService;
	@Autowired
	private SellerListService sellerListService;
	
	@GetMapping("/manager/sellerDelete")
	public String delete(Model model,@ModelAttribute SellerRequest seller,HttpServletRequest req)throws Exception{
		//인증확인도 해야함
		int sellerNo = Integer.parseInt(req.getParameter("sellerNo"));
		String error = sellerDeleteService.deleteSeller(sellerNo);
		List<Seller> sellerList = sellerListService.selectSellerList();
		model.addAttribute("sellerList", sellerList);
		model.addAttribute("error", error);
		return "/manager/sellerList";
	}

	
	
	
}
