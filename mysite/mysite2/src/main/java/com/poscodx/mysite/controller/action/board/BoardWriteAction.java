package com.poscodx.mysite.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;



public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao dao = new BoardDao();
		HttpSession session = request.getSession(true);
		
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String parentNo = request.getParameter("parentNo");
		
		if (parentNo == null || parentNo.equals("")) {
			BoardVo boardVo = new BoardVo();
			boardVo.setContents(contents);
			boardVo.setHit(0);
			boardVo.setTitle(title);
			boardVo.setUserNo(userVo.getNo());
			
			// depth 반드시 0
			boardVo.setDepth(0);
			
			// 가장 큰 그룹 + 1
			Long groupNumber = dao.getNextGNo();
			boardVo.setGno(groupNumber);
			
			// 반드시 1
			boardVo.setOno(1L);
			
			dao.insert(boardVo);
			
			response.sendRedirect(request.getContextPath() + "/board");
		}else {
			BoardVo boardVo = new BoardVo();
			boardVo.setContents(contents);
			boardVo.setHit(0);
			boardVo.setTitle(title);
			boardVo.setUserNo(userVo.getNo());
			
			System.out.println(parentNo);
			BoardVo parentVo = dao.findBoardByNo(Long.parseLong(parentNo)).get(0);
			System.out.println(parentVo.getOno());
			
			int targetDepth = parentVo.getDepth();
			// depth는 target + 1
			boardVo.setDepth(targetDepth + 1);
			
			Long targetGno = parentVo.getGno();
			// group은 parent Group
			boardVo.setGno(targetGno);
			
			Long targetOno = parentVo.getOno();
			// order는 
			boardVo.setOno(targetOno + 1);
			
			dao.updateForInsertReply(targetGno,targetOno+1);
	
			
			dao.insert(boardVo);
			
			response.sendRedirect(request.getContextPath() + "/board");
			
		}
		
		
		
	}

}
