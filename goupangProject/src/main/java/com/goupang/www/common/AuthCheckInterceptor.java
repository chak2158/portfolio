package com.goupang.www.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.goupang.www.dto.member.AuthInfo;

public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		//세션 객체를 만듬
		HttpSession session = request.getSession(false);
		//세션이 있고
		if (session != null) {
			//인증을 받고
			Object authInfo = session.getAttribute("authInfo");
			//인증이 있으면
			if (authInfo != null) {
				AuthInfo auth = (AuthInfo)authInfo;
				//memberNumber
				//auth.getId();
				//auth.getGrant();
				//로그인중 권한이 변경된 경우 처리
				if(auth.getGrant() == 0 ) {
					response.sendRedirect(request.getContextPath() + "/member/noGrant");
					return false;
				}
				return true;
			}
		}
		//인증이 없으면
		response.sendRedirect(request.getContextPath() + "/member/login");
		return false;
	}

}
