package bookshop.vo;

public class AuthorVo {
	
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
	
	public AuthorVo(Long no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public AuthorVo(String name) {
		this.name = name;
	}
	
	public AuthorVo() {
		
	}
	private Long no;
	private String name;
	
	
}
