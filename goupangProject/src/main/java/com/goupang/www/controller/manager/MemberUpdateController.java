package com.goupang.www.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.controller.inquiry.Pagination;
import com.goupang.www.dto.member.Member;
import com.goupang.www.service.manager.MemberListService;
import com.goupang.www.service.manager.MemberUpdateService;

@Controller
public class MemberUpdateController {

	@Autowired
	private MemberUpdateService memberUpdateService;
	@Autowired
	private MemberListService memberListService;

	


	@GetMapping("/manager/memberList2")
	public String submit(Model model, @ModelAttribute("member") Member member,
			@RequestParam(defaultValue="1") int curPage,
            HttpServletRequest request) throws Exception {
		memberUpdateService.updateMember(member);
		List<Member> memberList = memberListService.selectMemberList();
		model.addAttribute("memberList", memberList);

		int listCnt = memberListService.MemberCnt();
        Pagination pagination = new Pagination(listCnt, curPage);
	    List<Member> memberList2 = memberListService.MemberList2(pagination.getStartIndex(),(pagination.getStartIndex()+pagination.getPageSize()));
        model.addAttribute("listCnt", listCnt);
        model.addAttribute("pagination", pagination);
	    model.addAttribute("memberList", memberList2);
	    
		return "/manager/memberList";
	}

}
