package example;

public class DeptVo {

	private Long no;
	private String name;
	
	public DeptVo(Long no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
}
