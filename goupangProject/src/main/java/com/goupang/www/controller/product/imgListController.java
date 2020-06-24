package com.goupang.www.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductImage;
import com.goupang.www.dto.seller.Seller;
import com.goupang.www.service.product.ProductImgListService;
import com.goupang.www.service.product.ProductListService;



@Controller
public class imgListController {
	@Autowired
	private ProductImgListService productImgListService;
	
	@RequestMapping("/product/productImageList")
	public String list(Model model, @ModelAttribute("product") ProductImage productimage)throws Exception {
		//원래 다른곳에서 받아와야 할 번호
	    int productNo = productimage.getProductNo();
	    List<ProductImage> productList = productImgListService.selectImg(productNo);
	    model.addAttribute("productList", productList);	
	    
		return "/product/productDetailList";
	}
}
