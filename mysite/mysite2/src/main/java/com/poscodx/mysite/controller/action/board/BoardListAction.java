package com.poscodx.mysite.controller.action.board;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(Optional.ofNullable(request.getParameter("page")).orElse("1"));
		String key = request.getParameter("kwd");
		
		if (key == null || key.equals("")) {
			// 페이지를 기준으로 찾기
			List<BoardVo> voList = new BoardDao().findBoardsByPage(page);
			request.setAttribute("list", voList);
			int base = (page-1) / 5;
			int total = new BoardDao().getTotalBoardNo();
			int max = total / 5;
			if (total % 5 != 0) max += 1;
			final int fixedFinal = max;
			
			List<Page> pages = List.of(1,2,3,4,5).stream().map(e->{
				Page p = new Page();
				p.setPage(e + 5*base);
				p.setMovable(e + 5*base <= fixedFinal);
				return p;
			}).toList();
			
			
			
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("maxPage", fixedFinal);
			request.setAttribute("key", key);
		}else {
			List<BoardVo> voList = new BoardDao().findBoardsByPageAndKeyword(page,key);
			request.setAttribute("list", voList);
			
			int base = (page-1) / 5;
			int total = new BoardDao().getTotalBoardAndKeywordNo(key);
			int max = total / 5;
			if (total % 5 != 0) max += 1;
			final int fixedFinal = max;
			
			List<Page> pages = List.of(1,2,3,4,5).stream().map(e->{
				Page p = new Page();
				p.setPage(e + 5*base);
				p.setMovable(e + 5*base <= fixedFinal);
				return p;
			}).toList();
			
			
			
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("maxPage", fixedFinal);
			request.setAttribute("key", key);
		}
		
		
		
		
	
		
		request
		.getRequestDispatcher("/WEB-INF/views/board/list.jsp")
		.forward(request, response);
		
	}
	
	public static class Page{
		private int page;
		private boolean movable;
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public boolean isMovable() {
			return movable;
		}
		public void setMovable(boolean movable) {
			this.movable = movable;
		}
	}

}
