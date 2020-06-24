package com.goupang.www.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductImage;
import com.goupang.www.service.product.ProductImgListService;
import com.goupang.www.service.product.ProductListService;



@Controller
public class productDetailListController {
	@Autowired
	private ProductListService productListService;
	@Autowired
    private ProductImgListService productImgListService;
	
	@RequestMapping("/product/productDetailList")
	public String list(Model model, @ModelAttribute("product") Product product,@RequestParam int productNo)throws Exception {

	    List<Product> productList = productListService.selectProductByProductNo(productNo);
	    List<ProductImage> productImageList = productImgListService.selectImg(productNo);
	    model.addAttribute("productList", productList);		
	    model.addAttribute("productImageList", productImageList);
	    
	   
	    if(productImageList.size() != 0) {
	    String imgPath = productImageList.get(0).getProductImgPath();
	    String imgThPath = productImageList.get(0).getProductThumbPath();
	    model.addAttribute("imgPath",imgPath);
	    model.addAttribute("imgThPath",imgThPath);
	    }else {
	        String imgPath = "/uploadImages/202051035041468.jpg";
	        String imgThPath = "/uploadImages/thumb/202051072721382.jpg";
	        model.addAttribute("imgPath",imgPath);
	        model.addAttribute("imgThPath",imgThPath);
	    }
		return "/product/productDetailList";
	}
}
