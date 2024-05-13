package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		
		Set<String> s = new HashSet<>();
		
		s.add("둘리");
		s.add("몰리");
		s.add("마이클");

		String s1 = new String("둘리");
		
		// 과연? 4가 나올까? 3이 나올까? --> 3이 나온다
		System.out.println(s.size());
		
		// 순회1
		s.stream()
			.forEach(System.out::println);
		
		s.remove(2);
		
		// 순회2
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// 순회3
		for (String t:s) {
			System.out.println(t);
		}
		
		System.out.println(s.contains("둘리"));
	}
}
