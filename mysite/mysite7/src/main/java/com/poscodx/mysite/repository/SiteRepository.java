package com.poscodx.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.mysite.vo.SiteVo;

@Repository
public class SiteRepository {
	private SqlSession sqlSession;
	
	public SiteRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public SiteVo find() {
		return sqlSession.selectOne("site.findOldest");
	}

	public void update(SiteVo vo) {
		sqlSession.insert("site.insert", vo);
	}	
}
