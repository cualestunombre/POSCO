package chapter03;

public class Goods2 {
	
	public String name; // 모든 접근이 가능하다(접근에 제한이 없다)

	protected int price ; // 자식 + 디폴트까지 접근 가능하다 
	
	int countStock;  // 같은 패키지만 가능하다
	
	private int countSold; // 클래스 내부에서만접근 가능
	

}
