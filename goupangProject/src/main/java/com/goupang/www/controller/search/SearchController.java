package com.goupang.www.controller.search;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goupang.www.dao.search.SearchDAO;
import com.goupang.www.dto.product.Product;
import com.goupang.www.service.product.ProductListService;
import com.goupang.www.service.search.SearchService;



@Controller
public class SearchController {
	@Autowired
	SearchService searchService;

	
	@RequestMapping("/search/search")
	public String list(Model model, @RequestParam String keyword,RedirectAttributes redirect)throws Exception {
		List<Product> productList = null;
		//System.out.println(keyword);
		
			productList = searchService.selectProductList(keyword);
		if(productList.size() <= 0) {
			redirect.addAttribute(keyword);
			return "/search/noProductList";
		}

	    System.out.println(productList.get(0).getProductName());
	    System.out.println(productList.size());
	    model.addAttribute("productList", productList);	
	    
		return "/product/productCategoryList";
	}
	@RequestMapping("/search/noProductList")
	public void noList(@RequestParam String keyword)throws Exception {
	}
	@RequestMapping("/search/searchJson")
	@ResponseBody
	public List<String> json(@RequestParam String keyword)throws Exception {
		
		List<String> productList = searchService.selectProductNameList(keyword);
		return productList;
	}
}
