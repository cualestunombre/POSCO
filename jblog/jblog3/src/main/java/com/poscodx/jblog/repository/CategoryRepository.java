package com.poscodx.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Repository
public class CategoryRepository {
	private SqlSession sqlSession;
	
	public CategoryRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insert(CategoryVo vo) {
		sqlSession.insert("category.insert",vo);	
	}
	
	public List<CategoryVo> findByBlogId(String blogId){
		return sqlSession.selectList("category.findByBlogId",Map.of("blog_id",blogId));
	}
	
	public CategoryVo findByBlogIdAndName(String blogId, String name) {
		return sqlSession.selectOne("category.findByBlogIdAndName",Map.of("blog_id",blogId,"name",name));
	}
	
	public Long findDefaultCategoryNo(String blogId) {
		return sqlSession.selectOne("category.findDefaultCategoryNo",Map.of("blog_id",blogId));
	}

	public void delete(Long categoryNo) {
		sqlSession.delete("category.delete",Map.of("no",categoryNo));
	}
	
	public CategoryVo findByNo(Long categoryNo) {
		return sqlSession.selectOne("category.findByNo",Map.of("no",categoryNo));
	}

	
}
