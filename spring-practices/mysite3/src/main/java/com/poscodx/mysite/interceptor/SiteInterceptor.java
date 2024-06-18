package com.poscodx.mysite.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;
import com.poscodx.mysite.vo.UserVo;

public class SiteInterceptor implements HandlerInterceptor {
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private CookieLocaleResolver localeResolver;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		String language = localeResolver.resolveLocale(request).getLanguage();
		request.setAttribute("language",language);
		System.out.println(language);
		ServletContext context = request.getServletContext();
		if (context.getAttribute("site") == null) {
			SiteVo vo = siteService.getSite();
			context.setAttribute("site", vo);
		}
		
		
		
			return true;
		}
}
