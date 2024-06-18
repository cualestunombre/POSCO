package com.poscodx.jblog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poscodx.jblog.repository.UserRepository;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.UserVo;

@Service
@Transactional
public class UserService {
	
	private UserRepository userRepository;
	
	private BlogService blogService;
	
	public UserService(UserRepository userRepository,BlogService blogService) {
		this.userRepository = userRepository;
		this.blogService = blogService; 
	}
	
	public UserVo findUser(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}

	public void join(UserVo vo) {
		userRepository.insert(vo);
		BlogVo blogVo = new BlogVo();
		
		blogVo.setId(vo.getId());
		blogVo.setTitle(vo.getName());
		blogVo.setLogo("/assets/images/posco.png");
		
		blogService.addBlog(blogVo);
		
	}
}
