package com.poscodx.mysite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;

import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;


@Component
public class SiteInterceptor implements HandlerInterceptor {
	@Autowired
	private LocaleResolver localeResolver;
	

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// Locale

		request.setAttribute("language", localeResolver.resolveLocale(request).getLanguage());
		
		return true;
	}

}
