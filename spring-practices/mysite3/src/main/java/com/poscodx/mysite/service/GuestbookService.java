package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.GuestbookRepository;
import com.poscodx.mysite.repository.GuestbookRepositoryWithJdbcContext;
import com.poscodx.mysite.repository.GuestbookRepositoryWithJdbcTemplate;
import com.poscodx.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@Autowired
	private GuestbookRepositoryWithJdbcContext guestbookRepositoryWithJdbcContext;
	
	@Autowired
	private GuestbookRepositoryWithJdbcTemplate guestbookRepositoryWithJdbcTemplate;
	
	
	
	@Autowired
	public GuestbookService(GuestbookRepository guestbookRepository) {
		this.guestbookRepository = guestbookRepository;
	}
	
	public List<GuestbookVo> getContentsList(){
		return  guestbookRepositoryWithJdbcTemplate.findAll();
	}
	
	public void deleteContents(Long no, String password) {
		 guestbookRepository.deleteByNoAndPassword(no, password);
	}
	
	public void addContents(GuestbookVo vo) {
		 guestbookRepository.insert(vo);
	}

	public List<GuestbookVo> findAll() {
		return  guestbookRepositoryWithJdbcTemplate.findAll();
	}
}
