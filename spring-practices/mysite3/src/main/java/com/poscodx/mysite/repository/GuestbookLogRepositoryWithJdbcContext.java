package com.poscodx.mysite.repository;

import org.springframework.stereotype.Repository;

import com.poscodx.mysite.repository.template.JdbcContext;

@Repository
public class GuestbookLogRepositoryWithJdbcContext {
	private JdbcContext jdbcContext;
	
	public GuestbookLogRepositoryWithJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
	
	public int insert() {
		return jdbcContext.update("insert into guestbook_log values(current_date(),1)");
	}
	
	public int update() {
		return jdbcContext.update("update guestbook_log set count = count + 1 where date = DATE(NOW())");
	}
	
	
	public int update(Long no) {
		return jdbcContext.update("update guestbook_log set count = count - 1 where date = (select date(reg_date) from guestbook where no=?)",new Object[] {no});
	}
	
	
	

}
