package com.poscodx.mysite.controller;

import java.util.Map;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.controller.action.board.BoardDeleteAction;
import com.poscodx.mysite.controller.action.board.BoardListAction;
import com.poscodx.mysite.controller.action.board.BoardWriteAction;
import com.poscodx.mysite.controller.action.board.BoardWriteFormAction;
import com.poscodx.mysite.controller.action.board.ReplyFormAction;
import com.poscodx.mysite.controller.action.board.UpdateAction;
import com.poscodx.mysite.controller.action.board.UpdateFormAction;
import com.poscodx.mysite.controller.action.board.ViewAction;
import com.poscodx.mysite.controller.action.guestbook.AddAction;
import com.poscodx.mysite.controller.action.guestbook.DeleteAction;
import com.poscodx.mysite.controller.action.guestbook.DeleteFormAction;
import com.poscodx.mysite.controller.action.guestbook.ListAction;

public class BoardServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Action> mapAction = Map.of(
			"boardList", new BoardListAction(),
			"writeForm", new BoardWriteFormAction(),
			"write", new BoardWriteAction(),
			"view", new ViewAction(),
			"delete", new BoardDeleteAction(),
			"updateForm", new UpdateFormAction(),
			"update", new UpdateAction(),
			"replyForm", new ReplyFormAction()
		);
			
		@Override
		protected Action getAction(String actionName) {
			return mapAction.getOrDefault(actionName, new BoardListAction());
		}
}
