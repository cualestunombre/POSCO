package guestbook.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GuestbookVo {
	private Long no;
	private String name;
	private String password;
	private String contents;
	private Timestamp regtime;
	
	public GuestbookVo(String name,String password ,String contents) {
		this.name = name;
		this.contents = contents;
		this.password = password;
		this.regtime = Timestamp.valueOf(LocalDateTime.now());
	}

	public GuestbookVo(Long no ,String name,String password ,String contents,Timestamp regtime) {
		this.name = name;
		this.contents = contents;
		this.regtime = regtime;
		this.no = no;
		this.password = password;
	}
	public Long getNo() {
		return no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
}
