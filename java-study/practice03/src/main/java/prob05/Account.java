package prob05;

public class Account {
	
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println(accountNo +  " 계좌가 개설되었습니다");
	}
	
	public void save(int money) {
		balance += money;
	}
	
	public void deposit(int money) {
		balance -= money;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
}
