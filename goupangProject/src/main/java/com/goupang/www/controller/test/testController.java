package com.goupang.www.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	@RequestMapping("/test/addAPI")
	public String apiTest(){
		return "/test/addAPI";
	}
	
	
	@RequestMapping("/test/addMapAPI")
	public String mapApiTest(){
		return "/test/addMapAPI";
	}
}
