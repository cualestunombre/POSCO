package chapter04;



public class ObjectTest01 {
	
	public static void main(String[] args) {
		
		Point point = new Point(2,4);
		System.out.println(point.getClass());
		
		Class klass = point.getClass(); // reflection
		
		System.out.println(point.hashCode()); // address 기반의 해싱값
											  // address x, reference 값 x
		
		System.out.println(point.toString()); // 원래는 getClass() + "@" + hashCode() -> 16진수
		System.out.println(point);
		
		
		
		
		
	}

}
