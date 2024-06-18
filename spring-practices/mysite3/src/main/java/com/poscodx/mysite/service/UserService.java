package com.poscodx.mysite.service;

import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.UserRepository;
import com.poscodx.mysite.vo.UserVo;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void join(UserVo vo) {
		userRepository.insert(vo);
	}


	public UserVo getUser(Long no, String password) {
		return userRepository.findByNoAndPassword(no, password);
	}
	
	public UserVo getUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	public UserVo getUser(String email,String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}


	public UserVo getUser(Long no) {
			return userRepository.findByNo(no);
		
	}


	public void update(UserVo vo) {
		userRepository.update(vo);
		
	}
	
	
}
