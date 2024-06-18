package com.poscodx.jblog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private String description;
	private String join_date;
	private String blog_id;
	private int postCount;
	
	public int getPostCount() {
		return postCount;
	}
	
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public Long getNo() {
		return no;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	
	
}
