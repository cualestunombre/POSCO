package com.poscodx.mysite.vo;

public class BoardVo {
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getGno() {
		return gno;
	}
	public void setGno(Long gno) {
		this.gno = gno;
	}
	public Long getOno() {
		return ono;
	}
	public void setOno(Long ono) {
		this.ono = ono;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public String getName() {
		return name;
	}


	private Long no;
	private String title;
	private String contents;
	private int hit;
	private String regDate;
	private Long gno;
	private Long ono;
	private int depth;
	private Long userNo;
	private String name;


}
