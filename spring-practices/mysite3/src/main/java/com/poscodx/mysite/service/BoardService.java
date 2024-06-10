package com.poscodx.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.poscodx.mysite.controller.BoardController.Page;
import com.poscodx.mysite.repository.BoardRepository;
import com.poscodx.mysite.vo.BoardVo;

@Service
@Transactional
public class BoardService {
	private BoardRepository boardRepository;
	
	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	

	/*
	 수정된 서비스 코드
	 */
	
	// 페이지를 기준으로 board fetch
	public Map<String,Object> getContentsList(int page){
		Map<String,Object> map = new HashMap<>();
		int totalBoard = boardRepository.getTotalBoardNo(null);
		int totalPage = totalBoard % 5 != 0 ? totalBoard/5 + 1 : totalBoard/5;
		int base = (page-1)/5;
		
		
		List<Page> pages = List.of(1,2,3,4,5).stream().map(e->{
			Page p = new Page();
			p.setPage(e + 5*base);
			p.setMovable(e + 5*base <= totalPage);
			return p;
		}).toList();
		
		map.put("list", boardRepository.findBoardsByPage(page,null));
		map.put("pages", pages);
		map.put("page", page);
		map.put("maxPage", totalPage);
		
		return map;
		
		
	}
	
	// 페이지와 검색어 기준으로 board fetch
	public Map<String, Object> getContentsList(int page, String keyword) {
		Map<String,Object> map = new HashMap<>();
		int totalBoard = boardRepository.getTotalBoardNo(keyword);
		int totalPage = totalBoard % 5 != 0 ? totalBoard/5 + 1 : totalBoard/5;
		int base = (page-1)/5;
		
		
		List<Page> pages = List.of(1,2,3,4,5).stream().map(e->{
			Page p = new Page();
			p.setPage(e + 5*base);
			p.setMovable(e + 5*base <= totalPage);
			return p;
		}).toList();
		
		map.put("list", boardRepository.findBoardsByPage(page,keyword));
		map.put("pages", pages);
		map.put("page", page);
		map.put("maxPage", totalPage);
		
		return map;
	
	}
	
	// 삭제
	public void deleteContents(Long boardNo, Long userNo) {
		boardRepository.deleteByNo(boardNo, userNo);
	}
	
	// 수정
	public void updateContents(BoardVo vo, Long userNo) {
		boardRepository.update(vo.getNo(), vo.getTitle(), vo.getContents(),userNo);
	}
	
	// 글 내용
	public BoardVo getContents(Long no) {
		return boardRepository.findBoardByNo(no,null);
	}
	

	// 글 내용
	public BoardVo getContents(Long no,Long userNo) {
		return boardRepository.findBoardByNo(no,userNo);
	}
	
	public int getTotalPage() {
		int totalBoard = boardRepository.getTotalBoardNo(null);
		return totalBoard % 5 != 0 ? totalBoard/5 + 1 : totalBoard/5;
	}

	public int getTotalPageByKeword(String key) {
		int totalBoard = boardRepository.getTotalBoardNo(key);
		return totalBoard % 5 != 0 ? totalBoard/5 + 1 : totalBoard/5;
	}
	
	public void increaseHit(Long boardNo) {
		boardRepository.increaseHit(boardNo);
		
	}
	
	public void addContents(BoardVo vo) {
		BoardVo boardVo = new BoardVo();
		boardVo.setContents(vo.getContents());
		boardVo.setHit(0);
		boardVo.setTitle(vo.getTitle());
		boardVo.setUserNo(vo.getUserNo());
		
		// depth 반드시 0
		boardVo.setDepth(0);
		
		// 가장 큰 그룹 + 1
		Long groupNumber = boardRepository.getNextGNo();
		boardVo.setGno(groupNumber);
		
		// 반드시 1
		boardVo.setOno(1L);
		
		boardRepository.insert(boardVo);
		
	}

	public void addContents(BoardVo vo, Long parentNo) {
		BoardVo boardVo = new BoardVo();
		boardVo.setContents(vo.getContents());
		boardVo.setHit(0);
		boardVo.setTitle(vo.getTitle());
		boardVo.setUserNo(vo.getUserNo());
		
		BoardVo parentVo = boardRepository.findBoardByNo(parentNo,null);

		
		int targetDepth = parentVo.getDepth();
		boardVo.setDepth(targetDepth + 1);
		
		Long targetGno = parentVo.getGno();
		boardVo.setGno(targetGno);
		
		Long targetOno = parentVo.getOno();
		boardVo.setOno(targetOno + 1);
		
		boardRepository.updateForInsertReply(targetGno,targetOno+1);

		
		boardRepository.insert(boardVo);
		
	}

	
}
