package com.poscodx.mysite.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.security.AuthUser;
import com.poscodx.mysite.service.UserService;
import com.poscodx.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) {
		if(result.hasErrors()) {
//			model.addAttribute("userVo", vo);

//			List<ObjectError> list = result.getAllErrors();
//			for(ObjectError error:list) {
//				System.out.println(error);
//			}
			Map<String, Object> map = result.getModel();			
//			Set<String> s = map.keySet();
//			for(String key : s) {
//				model.addAttribute(key, map.get(key));
//			}
			model.addAllAttributes(map);
			
			return "user/join";
		}

		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}

	@RequestMapping(value="/joinsuccess", method=RequestMethod.GET)
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(required=false) String result) {
		return "user/login";
	}
	

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Authentication authentication, Model model) {
		UserVo authUser = (UserVo)authentication.getPrincipal();
		UserVo vo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo", vo);
		
		return "user/update";
	}
	

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Authentication authentication, UserVo vo) {
		UserVo authUser = (UserVo)authentication.getPrincipal();
		vo.setNo(authUser.getNo());
		userService.update(vo);
		
		authUser.setName(vo.getName());
		return "redirect:/user/update";
	}

	/*
	 * java 설정시 인터셉터를 쓰더라도, controller단에서 매치되는 url이 있어야 한다
	 */
	@RequestMapping("/auth")
	public void auth() {
	}

	@RequestMapping("/logout")
	public void logout() {
	}
	
}
