package com.goupang.www.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.seller.Seller;
import com.goupang.www.service.manager.MemberListService;

@Controller
public class MemberSelectListController {

	@Autowired
	private MemberListService memberListService;

	@RequestMapping("/manager/memberSelectList")
	public String selectByName(Model model, @ModelAttribute("memberName") String memberName, Member member)throws Exception {
		System.out.println(">>>>>>>>>>>>>>첫번째 컨트롤ㄹ러");
	    List<Member> memberSelectList = memberListService.selectByMemberName(memberName);
	    System.out.println(">>>>>>>>>>>>>>두번째 컨트롤ㄹ러");
	    model.addAttribute("memberList", memberSelectList);		
	    System.out.println(">>>>>>>>>>>>>>세번째 컨트롤ㄹ러");
		return "/manager/memberList";
	}
	
	

}
