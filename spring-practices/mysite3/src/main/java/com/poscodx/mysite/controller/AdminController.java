package com.poscodx.mysite.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.mysite.interceptor.Auth;
import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;

@Controller
@Auth(role="ADMIN")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private SiteService siteService;
	
	@GetMapping({"/main","/",""})
	public String main(Model model) {
		model.addAttribute("vo",siteService.getSite());
		return "admin/main";
	}
	
	@PostMapping("/main/update")
	public String updateMain(@RequestParam String welcome,@RequestParam String title, @RequestParam String des) {
		SiteVo vo = new SiteVo();
		vo.setDescription(des);
		vo.setTitle(title);
		vo.setWelcome(welcome);
		siteService.updateSite(vo);
		return "redirect:/admin";
		
	}
	
	@GetMapping({"/board"})
	public String board() {
		return "admin/board";
	}
	
	@GetMapping({"/user"})
	public String user() {
		return "admin/user";
	}
	
	@GetMapping({"/guestbook"})
	public String guestbook() {
		return "admin/guestbook";
	}

}
