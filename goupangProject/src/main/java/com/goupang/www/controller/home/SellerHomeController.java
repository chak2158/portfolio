package com.goupang.www.controller.home;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SellerHomeController {

	@GetMapping("/sellerHome")
	public String home(Model model, HttpServletRequest req)throws Exception{
	    HttpSession httpSession = req.getSession();
	    int sellerNo =1 /*(int) httpSession.getAttribute("sellerNo")*/;
	    model.addAttribute("sellerNo", sellerNo);
	    
		return "sellerHome";
	}
	
}
