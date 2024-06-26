package com.poscodx.hellospring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	
	@RequestMapping("/hello")
	public String helloResponse() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("name", name);
		mv.setViewName("/WEB-INF/views/hello3.jsp");
		return mv;
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
		
	}
	
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5(String name) {
		return name;
	}
		
	@RequestMapping("/hello6")
	public String hello6(String name) {
		return "redirect:/hello4";
	}
	
	@RequestMapping("/hello7")
	public void hello7(HttpServletResponse response) throws IOException{
		response.getWriter().print("<h1>cake cake cake cake cake</h1>");
	}
	
	
	
	

}
