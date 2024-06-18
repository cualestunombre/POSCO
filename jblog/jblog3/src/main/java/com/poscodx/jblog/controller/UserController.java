package com.poscodx.jblog.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.UserVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping("/loginform")
	public String loginForm() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(@Valid @ModelAttribute UserVo vo, BindingResult result,Model model) {
		if (result.hasErrors()) {
			Map map = result.getModel();
			model.addAllAttributes(map);
			return "user/join";
		}
		
		userService.join(vo);

		
		
		return "user/joinsuccess";
		
		
		
	}
}
