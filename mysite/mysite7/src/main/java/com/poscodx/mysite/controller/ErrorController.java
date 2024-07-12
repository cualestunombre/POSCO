package com.poscodx.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ErrorController {
	
	@GetMapping("/error/404")
	public String error404(){
		return "errors/404";
	}
	
	@RequestMapping("/error/500")
	public String error500() {
		return "errors/500";
	}
	
	@RequestMapping("/error/400")
	public String error400(){
		return "errors/400";
	}
}
