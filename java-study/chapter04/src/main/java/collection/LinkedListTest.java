package collection;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
public static void main(String[] args) {
		
		List<String> list = new LinkedList<>();
		
		list.add("둘리"); list.add("마이콜"); list.add("또치");
		
		// 순회1
		list.stream()
			.forEach(System.out::println);
		
		list.remove(2);
		
		// 순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// 순회3
		for (String s:list) {
			System.out.println(s);
		}
	}
}
