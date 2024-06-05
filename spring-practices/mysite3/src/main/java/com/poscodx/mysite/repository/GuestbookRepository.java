package com.poscodx.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int deleteByNoAndPassword(Long no, String password) {
		int result = sqlSession.delete("guestbook.deleteByNoAndPassword",Map.of("no",no,"password",password));
		return result;		
	}
	
	public int insert(GuestbookVo vo) {
		int result = sqlSession.insert("guestbook.insert",vo);
		return result;
		
	
		
	}
	
	public List<GuestbookVo> findAll() {
		
		List<GuestbookVo> list = sqlSession.selectList("guestbook.findAll");
		
		return list;
	}
	
}
