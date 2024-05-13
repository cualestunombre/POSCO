package draw;

public class GraphicText implements Drawable {
	
	private String text;

	@Override
	public void draw() {
		System.out.println("텍스트: " + text + "를 그렸습니다");
	}
	

}
