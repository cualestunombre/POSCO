package com.poscodx.mysite.controller.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Long boardNo = Long.parseLong(request.getParameter("no"));
	    String pageNo = request.getParameter("page");
	    
	    // 쿠키 확인 및 조회수 증가 로직
	    boolean hasCookie = false;
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("boardView_" + boardNo)) {
	                hasCookie = true;
	                break;
	            }
	        }
	    }

	    if (!hasCookie) {
	        new BoardDao().increaseHit(boardNo);
	        Cookie cookie = new Cookie("boardView_" + boardNo, "true");
	        cookie.setMaxAge(60 * 60 * 24); // 쿠키 유효 시간: 1일
	        cookie.setPath("/");
	        response.addCookie(cookie);
	    }

	    // 게시글 데이터 조회 및 JSP 포워딩
	    List<BoardVo> vo = new BoardDao().findBoardByNo(boardNo);
	    request.setAttribute("vo", vo.get(0));
	    request.setAttribute("page", pageNo);
	    
	    request
	            .getRequestDispatcher("/WEB-INF/views/board/view.jsp")
	            .forward(request, response);
	}


}
