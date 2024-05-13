package chapter04;



public class ObjectTest02 {
	public static void main(String[] args) {
		
		
		Point point = new Point(2,4);
		Point point2 = new Point(2,4);
		
		
		if (point.equals(point2)) {
			System.out.println("둘은 같다");
		}else {
			System.out.println("둘은 다르다");
		}
		
		
		
		
	}
}
