package prob02;

public class Book {
	private int bookNo;
	private String author;
	private String title;
	private int statusCode;
	
	public Book(int bookNumber, String author, String title) {
		this.bookNo = bookNumber;
		this.author = author;
		this.title = title;
		this.statusCode = 1;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getBookNumber() {
		return bookNo;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
}
