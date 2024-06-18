package com.poscodx.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.jblog.interceptor.AuthUser;
import com.poscodx.jblog.vo.UserVo;

@Controller
@RequestMapping
public class MainController {
	
	@GetMapping({"main",""})
	public String main(@AuthUser UserVo userVo,Model model) {
		model.addAttribute("authUser", userVo);
		return "main/index";
	}

}
