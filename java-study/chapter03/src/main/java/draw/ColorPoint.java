package draw;

public class ColorPoint extends Point{
	private String color;
	
	public ColorPoint(int x, int y,String color) {
		// 부모는 기본 생성자가 없기 때문에 다음 코드는 에러가 발생한다
		// super();
		super(x,y);
		this.color = color;
	}
	
	public String getColor() {return color;}
	
	public void setColor(String color) {this.color = color;}
	
	@Override
	public void draw() {
		int x = super.getX();
		int y = super.getY();
		
		System.out.println("점("+x+","+y+ ",color=" + color + ")을 그렸습니다");
		
	}
	
	
	
}
