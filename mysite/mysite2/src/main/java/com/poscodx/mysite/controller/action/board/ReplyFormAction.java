package com.poscodx.mysite.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;

public class ReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		Long parentNo = Long.parseLong(request.getParameter("no"));
		request.setAttribute("parentNo", parentNo);
		
		request
		.getRequestDispatcher("/WEB-INF/views/board/write.jsp")
		.forward(request, response);
		
	}

}
