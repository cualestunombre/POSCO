package prob5;

import java.util.Arrays;

public class MyStack {
	private String[] array;
	private int pos;
	
	public MyStack(int size) {
		array = new String[size];
		pos = 0;
	}
	
	public void push(String s) {
		
		if (array.length <= pos) {
			
			String[] temp = new String[array.length*2];
			for (int i = 0 ; i < array.length ; i ++) {
				temp[i] = array[i];
			}
			
			array = temp;
		
		}
		
		array[pos] = s;
		pos ++ ; 
			
	}
	
	public boolean isEmpty() {
		return pos == 0;
	}
	
	public String pop() throws MyStackException {
		if (isEmpty()) throw new MyStackException("stack is empty");
		pos -= 1;
		
		return array[pos];
	}
	
	
	
	
}