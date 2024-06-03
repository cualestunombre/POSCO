package com.poscodx.mysite.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String join() {
		return "/user/joinform";
	}
	
	@PostMapping("/join")
	public String join(UserVo vo) {
		userService.join(vo);
		
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
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, UserVo vo,Model model) {
		UserVo authUser = userService.getUser(vo.getEmail(),vo.getPassword());
		if (authUser == null) {
			model.addAttribute("email",vo.getEmail());
			model.addAttribute("result","fail");
			return "/user/loginform";
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		return "redirect:/main";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/main";
	}
	
	@GetMapping("/update")
	public String update(HttpSession session, Model model ) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null ) {
			return "redirect:/main";
		}
		
		UserVo vo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo",vo);
		
		return "user/updateform";
		
		
	}
	
	@PostMapping("/update")
	public String update(HttpSession session,UserVo vo) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null ) {
			return "redirect:/main";
		}
		
		
		vo.setNo(authUser.getNo());
		
		
		userService.update(vo);
	
		authUser.setName(vo.getName());
	
	
		
		return "redirect:/main";
		
		
	}
	

}
