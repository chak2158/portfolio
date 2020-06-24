package com.goupang.www.controller.manager;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.goupang.www.dto.member.Member;
import com.goupang.www.service.manager.MemberDeleteService;
import com.goupang.www.service.manager.MemberListService;


@Controller
public class MemberDeleteController {
	@Autowired
	private MemberDeleteService memberDeleteService;
	@Autowired
	private MemberListService memberListService;
	
	@GetMapping("/manager/memberDelete")
	public String delete(Model model,@ModelAttribute Member member,HttpServletRequest req)throws Exception{
		//인증확인도 해야함
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		String error = memberDeleteService.deleteMember(memberNo);
		List<Member> memberList = memberListService.selectMemberList();
		model.addAttribute("memberList", memberList);
		model.addAttribute("error", error);
		return "/manager/memberList";
	}

	
	
}
