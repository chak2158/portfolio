package com.goupang.www.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.dto.category.Category;
import com.goupang.www.service.category.CategoryListService;



@Controller
public class categoryListController {
	@Autowired
	private CategoryListService categoryListService;
	
	@RequestMapping("/category/categoryList")
	public String list(Model model, @RequestParam("categoryNo") int categoryNo)throws Exception {
		//원래 다른곳에서 받아와야 할 번호
	  
	    List<Category> categoryList = categoryListService.selectCategoryList(categoryNo);
	    model.addAttribute("categoryList", categoryList);		
	    System.out.println("categoryList"+categoryList);
//	    Inquiry inquiry = new Inquiry();
//	    model.addAttribute("inquiry", inquiry);
	    
		return "/product/productCategoryList";
	}
}
