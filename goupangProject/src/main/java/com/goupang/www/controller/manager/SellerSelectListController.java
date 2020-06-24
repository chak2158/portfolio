package com.goupang.www.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goupang.www.dto.product.Product;
import com.goupang.www.service.manager.SellerListService;

@Controller
public class SellerSelectListController {

	@Autowired
	private SellerListService sellerListService;

	@RequestMapping("/manager/sellerList/{sellerNo}")
	   public String listBySellerNo(@PathVariable("sellerNo") int sellerNo, Model model) throws Exception {
	      List<Product> productList = sellerListService.selectBySellerNo(sellerNo);
	      model.addAttribute("productList", productList);
	      System.out.println(">>>>>>>>>>>>>컨트롤러 까지");
	      return "manager/productList";

	   }
	
	

}
