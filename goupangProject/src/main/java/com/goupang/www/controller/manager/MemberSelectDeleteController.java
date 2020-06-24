package com.goupang.www.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.member.Member;
import com.goupang.www.service.manager.MemberDeleteService;
import com.goupang.www.service.manager.MemberListService;

@Controller
public class MemberSelectDeleteController {
	@Autowired
	private MemberDeleteService memberDeleteService;

	@ResponseBody
	@RequestMapping(value = "/manager/selectDelete", method = RequestMethod.POST)
	public int deleteCart( @RequestParam(value = "chbox[]") List<String> chArr, Member member)
			throws Exception {
		
		
		int memberNo = 0;
		int result = 0;
		System.out.println("chbox[] : " + chArr);
	
			for (String i : chArr) {
				memberNo = Integer.parseInt(i);
				System.out.println("cartNo[] : " + memberNo);
				member.setMemberNo(memberNo);
				memberDeleteService.deleteMember(memberNo);
				System.out.println(memberNo);
			}
			result = 1;
		
		return result;

	}
}
