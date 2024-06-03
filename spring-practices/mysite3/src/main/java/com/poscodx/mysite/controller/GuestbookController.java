package com.poscodx.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.mysite.service.GuestbookService;
import com.poscodx.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	private GuestbookService guestbookService;
	
	@Autowired
	public GuestbookController(GuestbookService guestbookService) {
		this.guestbookService = guestbookService;
	}
	
	
	@GetMapping(value= {"/",""})
	public String index(Model model) {
		List<GuestbookVo> list = guestbookService.findAll();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam Long no, @RequestParam String password) {
		guestbookService.deleteContents(no, password);
		return "redirect:/guestbook";
	}
	
	@GetMapping("/delete")
	public String deleteform(@RequestParam Long no) {
		return "guestbook/deleteform";
	}
	@PostMapping(value= {"","/"})
	public String write(GuestbookVo vo) {
		guestbookService.addContents(vo);
		return "redirect:/guestbook";
		
	}
}
