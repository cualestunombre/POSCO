package com.poscodx.jblog.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;

@Repository
public class BlogRepository {
	private SqlSession sqlSession;
	
	public BlogRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insert(BlogVo vo) {
		sqlSession.insert("blog.insert",vo);
	}
	
	public BlogVo findById(String id) {
		return sqlSession.selectOne("blog.findById",Map.of("id",id));
	}

	public void update(BlogVo vo) {
		sqlSession.update("blog.update",Map.of("id",vo.getId(),"logo",vo.getLogo(),"title",vo.getTitle()));
	}
}
