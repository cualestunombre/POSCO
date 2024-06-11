package com.poscodx.mysite.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;
import com.poscodx.mysite.vo.UserVo;

public class SiteInterceptor implements HandlerInterceptor {
	
	@Autowired
	private SiteService siteService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		ServletContext context = request.getServletContext();
		if (context.getAttribute("site") == null) {
			SiteVo vo = siteService.getSite();
			context.setAttribute("site", vo);
		}
		
		
		
			return true;
		}
}
