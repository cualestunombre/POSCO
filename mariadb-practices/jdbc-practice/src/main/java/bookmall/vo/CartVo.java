package bookmall.vo;

public class CartVo {
	private Long userNo;
	private Long bookNo;
	private String bookTitle;
	private int quantity;
	
	public CartVo(Long userNo,Long bookNo, String bookTitle,Integer quantity) {
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.quantity = quantity;
	}
	
	public CartVo() {}
	
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}