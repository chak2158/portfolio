package com.goupang.www.controller.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goupang.www.dto.member.AuthInfo;
import com.goupang.www.dto.member.LoginCommand;
import com.goupang.www.exception.member.WrongIdPasswordException;
import com.goupang.www.service.member.AuthService;



@Controller
public class LoginController {
	@Autowired
    private AuthService authService;

    @GetMapping("/member/login")
    public String form(LoginCommand loginCommand,
    		@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
    	return "/member/loginForm";
    }

    @PostMapping("/member/login")
    public String submit(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
    	//System.out.println("loginType:"+loginCommand.getLoginType());
        new LoginCommandValidator().validate(loginCommand, errors);
        String returnPage = "/unknownErrorPage";
        if (errors.hasErrors()) {
            return "/member/loginForm";
        }
        int loginType = loginCommand.getLoginType();
        try {
        	//System.out.println(loginCommand.getEmail());
        	//System.out.println(loginCommand.getPassword());
            AuthInfo authInfo = null;
            if(loginType > 3 || loginType < 1) {
            	return "/unknownErrorPage";
            }
            if(loginType == 1) {
            	authInfo = authService.authenticate(
            			loginCommand.getEmail(),
            			loginCommand.getPassword());  
            	returnPage="/home";
            }
            if(loginType == 2) {
            	authInfo = authService.sellerAuthenticate(
            			loginCommand.getEmail(),
            			loginCommand.getPassword());  
            	returnPage="/sellerHome";
            }
            if(loginType == 3) {
            	authInfo = authService.managerAuthenticate(
            			loginCommand.getEmail(),
            			loginCommand.getPassword());
            	returnPage="manager/adminhome";
            	
            }

            session.setAttribute("authInfo", authInfo);

			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

            return returnPage;
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "/member/loginForm";
        }
    }
}
