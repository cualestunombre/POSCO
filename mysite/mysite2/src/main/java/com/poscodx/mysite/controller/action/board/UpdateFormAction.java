package com.poscodx.mysite.controller.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long boardNo = Long.parseLong(request.getParameter("no"));
		
		List<BoardVo> list = new BoardDao().findBoardByNo(boardNo);
		request.setAttribute("vo", list.get(0));
		
		
		request
		.getRequestDispatcher("/WEB-INF/views/board/modify.jsp")
		.forward(request, response);
		
	}

}