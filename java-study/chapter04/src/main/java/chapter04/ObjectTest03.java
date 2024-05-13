package chapter04;



import java.util.HashSet;
import java.util.Set;


public class ObjectTest03 {
	public static void main(String[] args) {
		
		Set<Rect> set = new HashSet<>();
		
		Rect r1 = new Rect(2,4);
		Rect r2 = new Rect(4,2);
		
		
		set.add(r1);
		set.add(r2);
		
		
		for (Rect r : set) {
			System.out.println(r);
		}
		
		/*
		 * Collection을 사용하면 먼저 hashCode()가 같은 것이 있는 지 확인하고, 추후 equals()로 값을비교한다
		 * 따라서 equals와 hashCode를 같이 재정의 하는 것이 좋다
		 */
		
		String s = "a";
		String b = "a";
		String c = new String("a");
		
		System.out.println(s==b);
		System.out.println(b==c);
		
		System.out.println(System.identityHashCode(s) == System.identityHashCode(b));
		
		
		
		
	}

}
