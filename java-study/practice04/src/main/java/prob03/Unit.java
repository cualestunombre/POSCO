package prob03;

public abstract class Unit {
	private int x;
	private int y;
	
	public Unit(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	void stop() {
		/*
		 * 멈추는 로직
		 */
	}
	
	

}
