package com.poscodx.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.jblog.service.UserService;


public class LogoutInterceptor implements HandlerInterceptor {

private UserService userService;
	
	public LogoutInterceptor(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("authUser");
			session.invalidate();
			
		}
		
		/*
		 * 로그아웃
		 */
	
		response.sendRedirect(request.getContextPath());
		
		return false;
		
		
		
	}
}
