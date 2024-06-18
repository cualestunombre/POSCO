package com.poscodx.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.repository.CategoryRepository;
import com.poscodx.jblog.repository.PostRepository;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Service
@Transactional
public class BlogService {
	
	private BlogRepository blogRepository;
	
	private CategoryRepository categoryRepository;
	
	private PostRepository postRepository;
	
	public BlogService(BlogRepository blogRepository, CategoryRepository categoryRepository,PostRepository postRepository) {
		this.postRepository = postRepository;
		this.blogRepository = blogRepository;
		this.categoryRepository = categoryRepository;
	}
	
	
	// 블로그 생성
	public void addBlog(BlogVo vo) {
		// 블로그 생성
		blogRepository.insert(vo);
		
		// 디폴트 카테고리 생성
		CategoryVo categoryVo = new CategoryVo();
		
		categoryVo.setBlog_id(vo.getId());
		categoryVo.setName("미분류");
		categoryVo.setDescription("미분류 카테고리 입니다");
		
		categoryRepository.insert(categoryVo);
		
		
		
	}

	// 블로그 id로 블로그 정보를 불러오기
	public BlogVo getBlog(String id) {
		// 블로그 찾기
		BlogVo vo = blogRepository.findById(id);
		System.out.println(id);
		if (vo == null) throw new NoSuchElementException("해당하는 블로그가 없습니다");
		return vo;
	}


	// 블로그 id로 카테고리 불러오기
	public List<CategoryVo> getCateogries(String id) {
		return categoryRepository.findByBlogId(id);
	}
	
	public PostVo getPost(Long postNo) {
		return postRepository.findByPostNo(postNo);
	}
	
	// cateogry no에 해당하는 게시글 불러오기
	public List<PostVo> getPosts(Long categoryNo){
		return postRepository.findByCategoryNo(categoryNo);
	}


	public Map<String, Object> renderMain(String id, Optional<Long> categoryNo, Optional<Long> postNo) {
		Map<String,Object> map = new HashMap<>();
		
		// 블로그 정보
		BlogVo blogVo = getBlog(id);
		
		// 카테고리 리스트
		List<CategoryVo> categoryList = getCateogries(blogVo.getId());
		
		Long cno = categoryNo.orElse(
				categoryRepository.findDefaultCategoryNo(id)
				);
		
		
		// 카테고리 게시글 리스트
		List<PostVo> postList = getPosts(cno);
		
		// 현재 게시글
		Long pno = postNo.orElse(
				postRepository.findDefaultPostNo(cno)
				);
		
		PostVo postVo = getPost(pno);
		
		map.put("blogVo", blogVo);
		map.put("cno", cno);
		map.put("pno", pno);
		map.put("categoryList", categoryList);
		map.put("postList",postList);
		map.put("postVo",postVo);
		
		
		
		return map;
		
		
	}


	public void update(BlogVo vo) {
		blogRepository.update(vo);
		
	}


	public void addCategory(CategoryVo categoryVo) {
		categoryRepository.insert(categoryVo);
	}


	public void addPost(PostVo postVo) {
		postRepository.insert(postVo);
		
	}


	public void deleteCategory(Long categoryNo) {
		CategoryVo vo = categoryRepository.findByNo(categoryNo);
		if (vo.getPostCount() != 0) throw new IllegalStateException();
		categoryRepository.delete(categoryNo);
	}
}
