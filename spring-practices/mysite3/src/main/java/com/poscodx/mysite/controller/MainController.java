package com.poscodx.mysite.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping({"/","/main"})
	public String index(HttpServletRequest req) {
		
		// 서블릿 전역 변수 확인
		System.out.println(req.getServletContext().getInitParameter("contextConfigLocation"));
	
		Iterator<String> it = req.getServletContext().getAttributeNames().asIterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		if (req.getServletContext().getAttribute("xd") == null) {
			req.getServletContext().setAttribute("xd", "hd");
			
		}else {
			System.out.println(req.getServletContext().getAttribute("xd")+"123");
		}
		
		System.out.println(req.getServletContext().getAttribute("xd")+"456");
		
		
		return "main/index";
	}

}
