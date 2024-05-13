package chapter04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int h,int w) {
		this.h = h;
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "Rect [w="+w+", h=" + h +"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(w*h);
	}

}
