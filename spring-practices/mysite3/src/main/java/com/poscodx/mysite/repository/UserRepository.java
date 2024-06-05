package com.poscodx.mysite.repository;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.mysite.vo.UserVo;






@Repository
public class UserRepository {
	private SqlSession sqlSession;
	
	public UserRepository(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(UserVo vo) {
		int result = sqlSession.insert("user.insert",vo);
		return result;
	}

	public UserVo findByNoAndPassword(String email, String password) {
		UserVo result = sqlSession.selectOne("user.findByNoAndPassword",Map.of("email",email,"password",password));
		return result;
	}

	public UserVo findByNo(Long userNo) {
		UserVo result = sqlSession.selectOne("user.findByNo",userNo);
		return result;
	}

	public int update(UserVo vo) {
		int result = 0;
		
		result = sqlSession.update("user.updateGenderAndNameAndPassword",vo);
	
		
		
		return result;				
	}
}