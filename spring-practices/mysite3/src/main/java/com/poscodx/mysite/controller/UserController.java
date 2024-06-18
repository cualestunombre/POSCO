package com.poscodx.mysite.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.mysite.interceptor.Auth;
import com.poscodx.mysite.interceptor.AuthUser;
import com.poscodx.mysite.service.UserService;
import com.poscodx.mysite.vo.UserVo;



@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		return "/user/joinform";
	}
	
	@PostMapping("/join")
	public String join(@Valid @ModelAttribute UserVo userVo, BindingResult result,Model model) {
		if(result.hasErrors()) {
			
			Map map = result.getModel();
			model.addAllAttributes(map);
			return "user/joinform";
		}
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	
	@GetMapping("/joinsuccess")
	public String joinsuccess() {
		return "/user/joinsuccess";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/user/loginform";
	}
	
	
	
	@Auth
	@GetMapping("/update")
	public String update(HttpSession session,@AuthUser UserVo authUser, Model model ) {

	
		
		UserVo vo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo",vo);
		
		return "user/updateform";
		
		
	}
	
	@Auth
	@PostMapping("/update")
	public String update(@AuthUser UserVo authUser, UserVo vo) {
	

		
		
		vo.setNo(authUser.getNo());
		
		
		userService.update(vo);
	
		authUser.setName(vo.getName());
	
	
		
		return "redirect:/main";
		
		
	}
	

}
