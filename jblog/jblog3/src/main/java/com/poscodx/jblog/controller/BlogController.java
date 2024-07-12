package com.poscodx.jblog.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;

import com.poscodx.jblog.interceptor.Auth;
import com.poscodx.jblog.interceptor.AuthUser;
import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.UploadService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;
import com.poscodx.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets|upload-images|admin).*}")
public class BlogController {
	
	private BlogService blogService;
	
	private UploadService uploadService;
	
	public BlogController(BlogService blogService,UploadService uploadService) {
		this.blogService = blogService;
		this.uploadService = uploadService;
	}
	
	@GetMapping({"","/{categoryNo}","/{categoryNo}/{postNo}"})
	public String page(@PathVariable String id, @PathVariable Optional<Long> categoryNo, @PathVariable Optional<Long> postNo,
			Model model,@AuthUser UserVo userVo) {
		
		Map<String,Object> result = blogService.renderMain(id,categoryNo,postNo);

		
		model.addAllAttributes(result);
		model.addAttribute("authUser",userVo);
	
		
		
		return "blog/main";
	}
	
	@Auth
	@GetMapping("/admin/basic")
	public String adminBasicForm(@PathVariable  String id, @AuthUser UserVo userVo,Model model) {
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		
		model.addAttribute("authUser",userVo);
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin-basic";
	}
	
	@Auth
	@PostMapping("/admin/basic")
	public String adminBasic(@PathVariable String id, @AuthUser UserVo userVo, Model model, @RequestParam String title,
			@RequestParam("logo-file") MultipartFile file, @RequestParam String logoAddress) {
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		
		String path = uploadService.restore(file);
		BlogVo vo = new BlogVo();
		
		vo.setId(userVo.getId());
		vo.setLogo(path == null ? logoAddress : path );
		vo.setTitle(title);
		
		blogService.update(vo);
		
	
		return "redirect:/" + id + "/admin/basic";
		
	}
	
	@Auth
	@GetMapping("/admin/category")
	public String adminCategoryForm(@PathVariable String id,@AuthUser UserVo userVo,Model model) {
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		
		
		model.addAttribute("authUser",userVo);
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blogVo", blogVo);
		List<CategoryVo> categoryList = blogService.getCateogries(id);
		model.addAttribute("categoryList",categoryList); 
		
		

		return "blog/admin-category";
	}
	
	@Auth
	@PostMapping("/admin/category")
	public String adminCategory(@PathVariable String id, @AuthUser UserVo userVo 
			,Model model, @ModelAttribute CategoryVo categoryVo) {
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		
		categoryVo.setBlog_id(id);
		blogService.addCategory(categoryVo);
		
		return "redirect:/" + id + "/admin/category";
	}
	
	@Auth
	@GetMapping("/admin/category/delete")
	public String adminCategory(@PathVariable String id, @AuthUser UserVo userVo 
			,Model model, @RequestParam Long categoryNo) {
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		blogService.deleteCategory(categoryNo);
		
		return "redirect:/" + id + "/admin/category";
	}
	
	
	@Auth
	@GetMapping("/admin/write")
	public String adminWriteForm(@PathVariable String id,@AuthUser UserVo userVo,Model model) {
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		
		model.addAttribute("authUser",userVo);
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blogVo", blogVo);
		
		List<CategoryVo> categoryList = blogService.getCateogries(id);
		model.addAttribute("categoryList",categoryList);
		
	
		return "blog/admin-write";
	}
	
	
	@Auth
	@PostMapping("/admin/write")
	public String adminWrite(@PathVariable String id,Model model,@RequestParam Long categoryNo,
			@RequestParam String title, @RequestParam String contents, @AuthUser UserVo userVo) {
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		
		PostVo postVo = new PostVo();
		postVo.setCategory_no(categoryNo);
		postVo.setContents(contents);
		postVo.setTitle(title);
		
		blogService.addPost(postVo);
		
		if (!userVo.getId().equals(id)) throw new IllegalStateException();
		return "redirect:/"+id+"/admin/write";
	}
	
	
	
}
