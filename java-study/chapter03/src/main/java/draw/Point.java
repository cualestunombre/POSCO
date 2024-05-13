package draw;

import java.util.Objects;

public class Point implements Drawable {
	private int x;
	private int y;
	

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void draw() {
		System.out.println("점("+x+","+y+")을 그렸습니다");
	}
	
	public void show(boolean visible) {
		if(visible) {
			draw();
		}else {
			System.out.println("점("+x+","+y+")을 지웠습니다");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
	
	@Override
	public boolean equals(Object o) {
		return o.hashCode() == this.hashCode();
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
