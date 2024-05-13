package chapter03;

public class Goods2App {
	public static void main(String[] args) {
		
	
		
		Goods2 goods = new Goods2();
		
		// public은 접근제한이 없다
		goods.name = "camera";
		
		System.out.println(goods.name);
		
		// protected는 같은 패키지 접근이 가능하다
		// 더 중요한 것은 자식에서 접근이 가능하다는 것!!
		goods.price = 5000;
		
		
		// default는 같은 패키지에서 접근 수 있다. 
		
		// private은 내부에서만 접근이 가능하다
	
	
	}

}

