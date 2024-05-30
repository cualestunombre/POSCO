package com.poscodx.mysite.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class EncodingFilter extends HttpFilter implements Filter{
	
	private String encoding;
	
	@Override
	public void init(FilterConfig  config) {
		encoding = config.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "utf-8";
		}
		
	
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* 
		 * request 공통 처리
		 */
		
		

		request.setCharacterEncoding(encoding);
		
		
		chain.doFilter(request,response);
	}
}
