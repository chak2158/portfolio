package com.goupang.www.controller.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	

	@RequestMapping("/member/noGrant")
	public String noGrant() {
		return "member/noGrant";
	}
	

}
