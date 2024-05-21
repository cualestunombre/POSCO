package bookmall.vo;

public class OrderVo {
	private Long no;
	private String number;
	private int payment;
	private String shipping;
	private String status;
	private Long userNo;
	
	public OrderVo(Long no,String number,Integer payment,String shipping,String status,Long userNo) {
		this.no = no;
		this.number = number;
		this.payment = payment;
		this.shipping = shipping;
		this.status = status;
		this.userNo = userNo;
	}
	
	public OrderVo() {}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
}