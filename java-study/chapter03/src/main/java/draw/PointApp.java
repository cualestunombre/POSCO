package draw;

public class PointApp {
	public static void main(String[] args) {
		Point point = new Point(4,5);
//		point.setX(4);
//		point.setY(5);
		draw(point);
		
		point.show(false);
		
		ColorPoint point2  = new ColorPoint(100,200,"red");
		draw(point2);
		
		draw(new Triangle(null,"red","black"));
		draw(new Circle(null,"red","black"));
		draw(new Rectangle(null,"red","black"));
		
		Circle c = new Circle(null,"red","black");
		Triangle t = new Triangle(null,"red","black");
		Rectangle r = new Rectangle(null,"red","black");
		
		
		// 연산자 우측항이 클래스인 경우
		// instanceof 연산자는 hierarchy 상의 하위 상위만 instanceof 연산자를 사용할 수 있다
		Object o = new Object();
		System.out.println(o instanceof String);
		
		// 연산자 우측항이 인터페이스인 경우
		// instanceof 연산자는 hierarchy 상관없이 instanceof 연산자를 사용할 수 있다
		
		
		
	
		
	
	}
	
	private static void draw(Drawable drawable) {
		drawable.draw();
	}
	

	
	
}
