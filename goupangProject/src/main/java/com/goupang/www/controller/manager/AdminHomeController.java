package com.goupang.www.controller.manager;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.goupang.www.dto.member.AuthInfo;


@Controller
public class AdminHomeController {

	@GetMapping("/admin")
	public String home(HttpServletRequest req)throws Exception{
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		System.out.println("zz"+auth.getGrant());
		if(auth == null || auth.getGrant() < 3 ) {
			return "redirect:/member/noGrant";	
		}
		return "/manager/adminhome";
	}

	
	
}
