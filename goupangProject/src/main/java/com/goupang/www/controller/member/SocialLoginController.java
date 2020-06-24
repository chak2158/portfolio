package com.goupang.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.member.RegisterRequest;
import com.goupang.www.exception.member.DuplicateMemberException;
import com.goupang.www.exception.member.WrongIdPasswordException;
import com.goupang.www.service.member.AuthService;
import com.goupang.www.service.member.MemberRegisterService;



@Controller
public class SocialLoginController {
	@Autowired
	private MemberRegisterService memberRegisterService;
	@Autowired
    private AuthService authService;

	@GetMapping("/member/naverCallBack")
    public String form() {
		
    	return "/member/naverCallBack";
    }

    @GetMapping("/member/naverLoginSuccess")
	public String submit(
			HttpServletRequest req/* ,Errors errors */,HttpSession session,
    		HttpServletResponse response) {
    	String memberName = req.getParameter("name");
    	String memberEmail = req.getParameter("email");
    	String memberPw = req.getParameter("id");
//    	System.out.println(memberName);
//    	System.out.println(memberEmail);
//    	System.out.println(memberPw);
    	
    	RegisterRequest regReq = new RegisterRequest();
    	regReq.setEmail(memberEmail);
    	regReq.setName(memberName);
    	regReq.setPhone("0");
    	regReq.setPassword(memberPw);
    	regReq.setConfirmPassword(memberPw);
    	
		/*
		 * new RegisterRequestValidator().validate(regReq, errors); if
		 * (errors.hasErrors()) return "member/step2";
		 */
    	
		//로그인해봄
		try {
			AuthInfo authInfo = authService.authenticate(memberEmail,memberPw);
			session.setAttribute("authInfo", authInfo);
			return "/home";
		//로그인실패(사유 - 해당 이메일이 없거나 아이디,패스워드가 없을 경우)
		} catch (WrongIdPasswordException e) {
			//회원가입해봄
			try {
				memberRegisterService.regist(regReq);
				//다시 로그인해봄
				try {
					AuthInfo authInfo = authService.authenticate(memberEmail,memberPw);
					session.setAttribute("authInfo", authInfo);
					return "/home";
				//재로그인 실패
				} catch(WrongIdPasswordException ex) {
					System.out.println("WrongIdPasswordException");
					return "/unknownErrorPage";
				}
		    //회원가입 실패(사유 - 이메일 중복)
			} catch (DuplicateMemberException ex) {
				System.out.println("DuplicateMemberException");
				return "/unknownErrorPage";
			}
			
			/*
			 * errors.reject("idPasswordNotMatching"); errors.rejectValue("email",
			 * "duplicate");
			 */

		}
    	
    	
    	

    	
    	
    }
}
