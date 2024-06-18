package com.poscodx.mysite.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.poscodx.mysite.interceptor.Auth;
import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.service.UploadService;
import com.poscodx.mysite.vo.SiteVo;

@Controller
@Auth(role="ADMIN")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UploadService uploadService;
	
	@Autowired
	private SiteService siteService;
	
	@GetMapping({"/main","/",""})
	public String main(Model model) {
		model.addAttribute("vo",siteService.getSite());
		return "admin/main";
	}
	
	@PostMapping("/main/update")
	public String updateMain(@RequestParam( "file1" ) MultipartFile file1, @RequestParam String description,
			@RequestParam String welcome, @RequestParam String title,@RequestParam String profile,HttpServletRequest request) {
		
		String url = uploadService.restore(file1);
		SiteVo vo = new SiteVo();
		
		vo.setDescription(description);
		vo.setTitle(title);
		vo.setProfile(url);
		vo.setWelcome(welcome);
		siteService.updateSite(vo);
		
		if (url == null) {
			vo.setProfile(profile);
		}
		
		ServletContext context = request.getServletContext();
		context.setAttribute("site", vo);
		
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
