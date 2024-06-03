package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.BoardRepository;
import com.poscodx.mysite.vo.BoardVo;

@Service
public class BoardService {
	private BoardRepository boardRepository;
	
	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public List<BoardVo> findBoardByPage(int page){
		return boardRepository.findBoardsByPage(page);
	}
	
	public List<BoardVo> findBoardByPageAndKeyword(int page,String key){
		return boardRepository.findBoardsByPageAndKeyword(page,key);
	}
	
	public int getTotalPage() {
		int totalBoard = boardRepository.getTotalBoardNo();
		return totalBoard % 5 != 0 ? totalBoard/5 + 1 : totalBoard/5;
	}

	public int getTotalPageByKeword(String key) {
		int totalBoard = boardRepository.getTotalBoardAndKeywordNo(key);
		return totalBoard % 5 != 0 ? totalBoard/5 + 1 : totalBoard/5;
	}

	public void increaseHit(Long boardNo) {
		boardRepository.increaseHit(boardNo);
		
	}

	public List<BoardVo> findBoardByNo(Long boardNo) {
		return boardRepository.findBoardByNo(boardNo);
	}

	public void deleteByNo(Long no, Long userNo) {
		boardRepository.deleteByNo(no, userNo);
		
	}

	public void writeDefault(BoardVo vo, Long userNo) {
		BoardVo boardVo = new BoardVo();
		boardVo.setContents(vo.getContents());
		boardVo.setHit(0);
		boardVo.setTitle(vo.getTitle());
		boardVo.setUserNo(userNo);
		
		// depth 반드시 0
		boardVo.setDepth(0);
		
		// 가장 큰 그룹 + 1
		Long groupNumber = boardRepository.getNextGNo();
		boardVo.setGno(groupNumber);
		
		// 반드시 1
		boardVo.setOno(1L);
		
		boardRepository.insert(boardVo);
		
	}

	public void writeWithGroup(BoardVo vo, Long no, Long parentNo) {
		BoardVo boardVo = new BoardVo();
		boardVo.setContents(vo.getContents());
		boardVo.setHit(0);
		boardVo.setTitle(vo.getTitle());
		boardVo.setUserNo(no);
		
		BoardVo parentVo = boardRepository.findBoardByNo(parentNo).get(0);

		
		int targetDepth = parentVo.getDepth();
		boardVo.setDepth(targetDepth + 1);
		
		Long targetGno = parentVo.getGno();
		boardVo.setGno(targetGno);
		
		Long targetOno = parentVo.getOno();
		boardVo.setOno(targetOno + 1);
		
		boardRepository.updateForInsertReply(targetGno,targetOno+1);

		
		boardRepository.insert(boardVo);
		
	}

	public void update(BoardVo vo) {
		
		boardRepository.update(vo.getNo(), vo.getTitle(), vo.getContents());
	}
}
