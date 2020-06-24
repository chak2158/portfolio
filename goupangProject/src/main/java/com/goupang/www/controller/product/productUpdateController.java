package com.goupang.www.controller.product;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.goupang.www.dao.product.FileUploadDao;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductImage;
import com.goupang.www.dto.product.ProductRequest;
import com.goupang.www.service.product.FileUploadService;
import com.goupang.www.service.product.ProductListService;
import com.goupang.www.service.product.ProductUpdateService;

import sun.net.www.protocol.http.AuthCache;


@Controller
public class productUpdateController {
	@Autowired
	private ProductUpdateService productUpdateService;

	@Autowired
	private ProductListService productListService;
	   @Autowired
	    private FileUploadService fileUploadService;
	
	@PostMapping("/product/productUpdateForm")
	public void form(@ModelAttribute Product product)throws Exception{
		System.out.println(product.getProductNo());
	}
	
	@PostMapping("/product/productUpdate")
    public String submit(Model model,@ModelAttribute Product product,ProductRequest productReq)throws Exception {
	    
	    System.out.println(productReq.getProductNo());
	    
        int curProductNo=productUpdateService.updateProductList(product);
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
        System.out.println("product>>>>>>>>>>>>>>>>>"+product);
        productUpdateService.updateProductList(product);
        
        
        List<Product> productList = productListService.selectProductList(product.getSellerNo());
        model.addAttribute("productList", productList); 
        
        return "/product/sellerProductList";
    }
}
