package com.goupang.www.controller.product;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductRequest;
import com.goupang.www.service.product.FileUploadService;
import com.goupang.www.service.product.ProductFormService;
import com.goupang.www.service.product.ProductListService;


@Controller
public class productFormController {
	
	@Autowired
	private ProductFormService productFormService;
	@Autowired
	private ProductListService productListService;
	@Autowired
	private FileUploadService fileUploadService;
	@GetMapping("/product/regist")
	public String form(Model model, HttpServletRequest req,@ModelAttribute("product") Product product){
		ProductRequest productReq = new ProductRequest();
		AuthInfo auth =  (AuthInfo) req.getSession().getAttribute("authInfo");
		productReq.setSellerNo(auth.getId().intValue());
		/*원래는 다른 페이지에서 받아와야 되는 값들*/
		model.addAttribute("productRequest",productReq);
		return "/product/regist";
	}
	@PostMapping("/product/regist")
	public String submit(Model model,@ModelAttribute Product product,ProductRequest productReq)throws Exception {
	    int curProductNo=productFormService.insertProductList(productReq);
	    System.out.println(curProductNo);
	    MultipartFile[] file = productReq.getFiles();
	    
	    int result = 0;
	    if(file!=null) {
	        result = fileUploadService.restore(file,curProductNo);
	        
	    }
        String url = "";
        if(result > 0) {
            url = "result"; 
        }
        
		 List<Product> productList = productListService.selectProductList(product.getSellerNo());
		    model.addAttribute("productList", productList);
		return "/product/sellerProductList";
	}
	
	
	
}
