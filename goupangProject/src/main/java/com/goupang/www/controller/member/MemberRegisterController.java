package com.goupang.www.controller.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.dto.manager.Manager;
import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.member.RegisterRequest;
import com.goupang.www.dto.seller.Seller;
import com.goupang.www.exception.member.DuplicateMemberException;
import com.goupang.www.service.member.MemberRegisterService;







@Controller
public class MemberRegisterController {
	
	@Autowired
	private MemberRegisterService memberRegisterService;

	@RequestMapping("/member/step1")
	public String handleStep1() {
		return "member/step1";
	}

	@PostMapping("/member/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "member/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "member/step2";
	}
	
	@GetMapping("/member/step2")
	public String handleStep2Get() {
		return "redirect:/member/step1";
	}
	
	@PostMapping("/member/step3")
	public String handleStep3Post(RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
			return "member/step2";

		try {
			memberRegisterService.regist(regReq);
			return "member/step3";
		} catch (DuplicateMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "member/step2";
		}
	}

	
	@GetMapping("/member/managerForm")
	public String managerForm() {
		System.out.println("sdsssss");
		return "member/managerForm";
	}
	@PostMapping("/member/managerForm")
	public String mgrSubmit(@ModelAttribute("member") Member member) {
		System.out.println("sdsd11");
		Manager manager = new Manager(0, member.getMemberEmail(), member.getMemberPw());
		
		memberRegisterService.registManager(manager);
		System.out.println("sdsd22");
		return "member/step3";
	}
	
	@GetMapping("/member/sellerForm")
	public String sellerForm() {
		return "member/sellerForm";
	}
	@PostMapping("/member/sellerForm")
	public String sellerSubmit(@ModelAttribute("seller") Seller seller) {
		memberRegisterService.registSeller(seller);
		return "member/step3";
	}
}
