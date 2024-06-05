package com.poscodx.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Repository;

import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.GuestbookVo;

@Repository
public class BoardRepository {
	
	private SqlSession sqlSession;
	
	public BoardRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void deleteByNo(Long no, Long userNo) {
		Map<String,Object> map = new HashMap<>();
		map.put("no", no);
		map.put("userNo", userNo);
		sqlSession.delete("board.deleteByNo",map);
	}
	
	public Long getNextGNo() {
	    long nextGNo = sqlSession.selectOne("board.getNextGNo");
	    return nextGNo;
	}
	
	public int getTotalBoardNo(String key) {

		Map<String,Object> map = new HashMap<>();
		if (key != null && key.equals("")) {
			key = "%" + key + "%";
		}
		
		map.put("key", key);

	    int total = sqlSession.selectOne("board.getTotalBoardNo",map);
	    return total;
	}
	
	
	public List<BoardVo> findBoardsByPage(int page,String key){
		if (key == null) {
			key  = "";
		}else if (key.equals("")) {
			// do nothing
		}else {
			key = "%" + key + "%";
		}
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("page", page);
		map.put("key", key);
		
		List<BoardVo> result = 
				sqlSession.selectList("board.findBoardsByPage",map);
		
		return result;
	}
	
	public BoardVo findBoardByNo(Long boardNo, Long userNo){

		Map<String,Object> map = new HashMap<>();
		
		map.put("boardNo",boardNo);
		map.put("userNo", userNo);
		BoardVo result = 
				sqlSession.selectOne("board.findBoardByNo",map);
		
		return result;
	}
	
	
	
	
	public int insert(BoardVo vo) {
		int result = 
				sqlSession.update("board.insert",vo);
		
		return result;
	}

	public void update(Long boardNo, String title, String contents,Long userNo) {
		Map<String,Object> map = new HashMap<>();
		map.put("boardNo",boardNo);
		map.put("title",title);
		map.put("contents",contents);
		map.put("userNo", userNo);
		
		sqlSession.update("board.update",map);
	}

	public void updateForInsertReply(Long targetGno, Long targetOno) {
		Map<String,Object> map = new HashMap<>();
		map.put("targetGno", targetGno);
		map.put("targetOno", targetOno);
		sqlSession.update("board.updateForInsertReply",map);
		
	}

	public void increaseHit(Long boardNo) {
		Map<String,Object> map = new HashMap<>();
		map.put("boardNo", boardNo);
		sqlSession.update("board.increaseHit",map);
	}

	
		
	

}
