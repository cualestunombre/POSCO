package com.poscodx.mysite.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.mysite.repository.BoardRepository;
import com.poscodx.mysite.service.BoardService;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping(value= {"","/"})
	public String guestbook(Model model,@RequestParam(defaultValue="1",required=false) int page,@RequestParam(required=false) String kwd) {	
		Map<String,Object> map = null;
		if (kwd == null || kwd.equals("")) {
			map = boardService.getContentsList(page);
	
	
		}else {
			map = boardService.getContentsList(page, kwd);
		}
		
		model.addAllAttributes(map);
		model.addAttribute("key",kwd);
		
		return "board/list";
	}
	

	@PostMapping(value= {"","/"})
	public String write(@ModelAttribute BoardVo vo, @RequestParam(required=false) Long parentNo,HttpSession session) {
		UserVo userVo  = (UserVo) session.getAttribute("authUser");
		if (userVo == null) {
			return "redirect:/";
		}
		vo.setUserNo(userVo.getNo());
		if (parentNo == null) {
			boardService.addContents(vo);
		}else {

			boardService.addContents(vo,parentNo);
		}
		
		return "redirect:/board";
	}
	
	@GetMapping("/{boardNo}")
	public String view(@PathVariable("boardNo") Long boardNo,@RequestParam("page") int page, Model model,HttpServletRequest request ,HttpServletResponse response) {
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
	        boardService.increaseHit(boardNo);
	        Cookie cookie = new Cookie("boardView_" + boardNo, "true");
	        cookie.setMaxAge(60 * 60 * 24); // 쿠키 유효 시간: 1일
	        cookie.setPath("/");
	        response.addCookie(cookie);
	    }
	    
	    BoardVo vo = boardService.getContents(boardNo);
	    
	    model.addAttribute("vo", vo);
	    model.addAttribute("page", page);
	    
	    return "board/view";
	}
	
	@GetMapping("/delete")
	public String deleteBoard(@RequestParam("no")Long no,HttpSession session) {
		UserVo vo = (UserVo) session.getAttribute("authUser");
		if (vo == null) {
			return "redirect:/";
		}
		boardService.deleteContents(no, vo.getNo());
		return "redirect:/board";
	}
	
	@GetMapping("/write")
	public String writeForm(HttpSession session) {
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		if (userVo == null) {
			return "redirect:/";
		}
		return "board/write";
	}
	
	@GetMapping("/update")
	public String updateForm(@RequestParam Long no, Model model, HttpSession session) {
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		if (userVo == null) {
			return "redirect:/";
		}
		BoardVo vo = boardService.getContents(no,userVo.getNo());
		model.addAttribute("vo",vo);
		return "board/modify";
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardVo vo,HttpSession session) {
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		if (userVo == null) {
			return "redirect:/";
		}
		boardService.updateContents(vo,userVo.getNo());
		return "redirect:/board";
	}
	
	
	@GetMapping("/reply")
	public String replyForm(@RequestParam Long no,Model model,HttpSession session) {
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		if (userVo == null) {
			return "redirect:/";
		}
		model.addAttribute("parentNo",no);
		return "board/write";
		
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
