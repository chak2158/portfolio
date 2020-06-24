package com.goupang.www.controller.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.member.Member;
import com.goupang.www.service.member.MyPageService;

@Controller
public class MyPageController {
	
	@Autowired
	private MyPageService myPageService;
	
	@RequestMapping("/member/myPage")
	public String myPage(HttpServletRequest req,Model model) {
		AuthInfo auth = (AuthInfo) req.getSession().getAttribute("authInfo");
		if(auth == null) {
			
			return "redirect:/member/login";	
		}
		System.out.println(auth.getGrant());
		if(auth.getGrant()!=1||auth.getGrant()==0) {
			return "member/noMyPage";
		}
		System.out.println(auth.getGrant());
		int memberNo = auth.getId().intValue(); 
		Member member = myPageService.select(memberNo);
		model.addAttribute(member);
		
		return "member/myPage";
	}
	
}
