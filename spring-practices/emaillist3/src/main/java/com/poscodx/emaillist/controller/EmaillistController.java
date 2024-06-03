package com.poscodx.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.poscodx.emaillist.repository.EmaillistDao;
import com.poscodx.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	private EmaillistDao dao;
	
	@Autowired
	public EmaillistController(EmaillistDao dao) {
		this.dao = dao;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<EmaillistVo> list = dao.findAll();
		model.addAttribute("list", list);
		
		
		return "index";
	}
	
	@GetMapping("/mail")
	public String itemForm(Model model) {
		
		
		return "form";
	}
	
	@PostMapping("/mail")
	public String form(@ModelAttribute EmaillistVo vo) {
		dao.insert(vo);
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
}
