package com.poscodx.mysite.controller.action.board;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.*;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no = Long.parseLong(request.getParameter("no"));
		UserVo vo = (UserVo)request.getSession(true).getAttribute("authUser");
		
		new BoardDao().deleteByNo(no, vo.getNo());
		
		response.sendRedirect(request.getContextPath()+"/board");
		
	}

}