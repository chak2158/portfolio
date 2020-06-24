package com.goupang.www.controller.product;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.goupang.www.dto.product.Product;
import com.goupang.www.service.product.ProductDeleteService;
import com.goupang.www.service.product.ProductListService;


@Controller
public class productDeleteController {
	@Autowired
	private ProductDeleteService productDeleteService;
	@Autowired
	private ProductListService productListService;
	
	@GetMapping("/product/productDelete")
	public String delete(Model model,@ModelAttribute Product product,HttpServletRequest req)throws Exception{
		//인증확인도 해야함
		//int sellerNo = Integer.parseInt(req.getParameter("sellerNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		String error = productDeleteService.deleteProduct(productNo);
		List<Product> productList = productListService.selectProductList(productNo);
		model.addAttribute("productList", productList);
		model.addAttribute("error", error);
		return "redirect:/product/sellerProductList";
	}

}
