package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.GuestbookRepository;
import com.poscodx.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	private GuestbookRepository guestbookRepository;
	
	@Autowired
	public GuestbookService(GuestbookRepository guestbookRepository) {
		this.guestbookRepository = guestbookRepository;
	}
	
	public List<GuestbookVo> getContentsList(){
		return null;
	}
	
	public void deleteContents(Long no, String password) {
		
	}
	
	public void addContents(GuestbookVo vo) {
		
	}
}
