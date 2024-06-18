package com.poscodx.jblog.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.UserVo;

@Repository
public class UserRepository {
	private SqlSession sqlSession;
	
	public UserRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/*
	 * find, insert, update, delete
	 */
	
	public UserVo findByIdAndPassword(String id, String password) {
		return sqlSession.selectOne("user.findByIdAndPassword", Map.of("id",id,"password",password));
		
	}
	
	public void insert(UserVo vo) {
		sqlSession.insert("user.insert",vo);	
	}
	

}
