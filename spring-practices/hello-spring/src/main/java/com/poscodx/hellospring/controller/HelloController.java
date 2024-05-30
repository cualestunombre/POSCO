package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	
	
	@RequestMapping("/hello")
	public String helloResponse() {
		return "/WEB-INF/views/hello.jsp";
	}

}
