package emaillist.dao;

public class EmaillistVo {
	private String firstName; 
	private String lastName;
	private String email;
	
	public EmaillistVo(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEamil() {
		return email;
	}
	
	
}
