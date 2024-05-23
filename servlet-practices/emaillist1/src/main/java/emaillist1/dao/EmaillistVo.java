package emaillist1.dao;

public class EmaillistVo {
	private String firstName; 
	private String lastName;
	private String email;
	private Integer no;
	
	public EmaillistVo(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	

	
	
}
