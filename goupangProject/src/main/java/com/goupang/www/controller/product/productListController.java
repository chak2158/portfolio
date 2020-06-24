package com.goupang.www.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductRequest;
import com.goupang.www.service.product.ProductListService;



@Controller
public class productListController {
	@Autowired
	private ProductListService productListService;
	
	@RequestMapping("/product/sellerProductList")
	public String list(Model model, HttpServletRequest req,@ModelAttribute("product") Product product)throws Exception {

	    ProductRequest productReq = new ProductRequest();
        AuthInfo auth =  (AuthInfo) req.getSession().getAttribute("authInfo");
        productReq.setSellerNo(auth.getId().intValue());
        System.out.println("product.getSellerNo()>>>>>>>>>>>"+productReq.getSellerNo());
        model.addAttribute("productRequest",productReq);
	    
	    List<Product> productList = productListService.selectProductList(productReq.getSellerNo());
	    model.addAttribute("productList", productList);	
	    
		return "/product/sellerProductList";
	}
}
