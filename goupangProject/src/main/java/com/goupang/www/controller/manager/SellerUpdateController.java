package com.goupang.www.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.goupang.www.dto.seller.Seller;
import com.goupang.www.dto.seller.SellerRequest;
import com.goupang.www.service.manager.SellerUpdateService;
import com.goupang.www.service.manager.SellerListService;

@Controller
public class SellerUpdateController {

	@Autowired
	private SellerUpdateService sellerFormService;
	@Autowired
	private SellerListService sellerListService;

	


	@PostMapping("/manager/sellerList")
	public String submit(Model model, @ModelAttribute("selReq") SellerRequest selReq) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> controller: sellerGrant: " + selReq.getSellerGrant());
		sellerFormService.updateSeller(selReq);
		List<Seller> sellerList = sellerListService.selectSellerList();
		model.addAttribute("sellerList", sellerList);
		return "/manager/sellerList";
	}

}
