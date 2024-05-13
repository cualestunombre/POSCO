package draw;

public abstract class Shape implements Drawable {
	
	private Point[] points = new Point[100];
	private String fillColor;
	private String lineColor;
	
	public Shape(Point[] points,String fillColor, String lineColor) {
		this.points = points;
		this.fillColor = fillColor;
		this.lineColor = lineColor;
	}
	
	
	public abstract void draw();
	
	
	
	

}
