package com.poscodx.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Repository
public class PostRepository {
	private SqlSession sqlSession;
	
	public PostRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Long findDefaultPostNo(Long categoryNo) {
		return sqlSession.selectOne("post.findDefaultPostNo",Map.of("category_no",categoryNo));
	}
	
	public List<PostVo> findByCategoryNo(Long categoryNo) {
		return sqlSession.selectList("post.findByCategoryNo",Map.of("category_no",categoryNo));
	}

	public PostVo findByPostNo(Long postNo) {
		if (postNo == null) return null;
		return sqlSession.selectOne("post.findByPostNo",Map.of("no",postNo));
	}

	public void insert(PostVo postVo) {
		sqlSession.insert("post.insert",postVo);
		
	}
}