package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		
		// 힙상에 객체가 존재하게 된다
		Integer i = 10;
		Character c = 'c';
		Boolean b = true;
		Integer d = 10;
		
		if (i == d) System.out.println("yes");
		else System.out.println("no");
		
		Integer e = new Integer(10);
		
		// String과 비슷한 원리로 동작!!
		System.out.println(e==i);
	}
}
