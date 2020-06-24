package com.goupang.www.controller.manager;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminLogoutController {

	@GetMapping("/manager/logout")
	public String home()throws Exception{
		return "/manager/logout";
	}

	
	
}
