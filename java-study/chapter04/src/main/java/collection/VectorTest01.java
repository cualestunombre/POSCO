package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {
		
		Vector<String> vector = new Vector<>();
		
		vector.addElement("둘리");
		vector.addElement("마이클");
		vector.addElement("또치");
		
		for (int i = 0; i < vector.size(); i++) {
			String s = vector.elementAt(i);
			System.out.println(s);
		}
		
		// 삭제
		vector.removeElement(2);
		
		// 순회
		Enumeration<String> e = vector.elements();
		while(e.hasMoreElements()) {
			e.nextElement();
		}
		
	}
}
