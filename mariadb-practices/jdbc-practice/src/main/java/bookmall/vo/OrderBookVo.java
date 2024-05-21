package bookmall.vo;

public class OrderBookVo {
	private Long orderNo;
	private Long bookNo;
	private String bookTitle;
	private int quantity;
	private int price;
	
	public OrderBookVo(Long orderNo, Long bookNo, String bookTitle,Integer quantity, Integer price) {
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.quantity = quantity;
		this.price = price;
	}
	
	public OrderBookVo() {
		
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}	
}