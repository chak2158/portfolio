package com.goupang.www.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goupang.www.dto.seller.Seller;
import com.goupang.www.service.manager.SellerListService;

@Controller
public class SellerListController {

	@Autowired
	private SellerListService sellerListService;

	@RequestMapping("/manager/sellerList")
	public String list(Model model, @ModelAttribute("seller") Seller seller)throws Exception {
		//원래 다른곳에서 받아와야 할 상품번호
	    List<Seller> sellerList = sellerListService.selectSellerList();
	    model.addAttribute("sellerList", sellerList);		
	    
		return "/manager/sellerList";
	}
	
	

}
