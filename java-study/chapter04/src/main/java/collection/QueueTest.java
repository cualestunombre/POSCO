package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		System.out.println(q.peek());

		
		while(!q.isEmpty()){
			String s = q.poll();
			System.out.println(s);
		}
		
		// 비어있을 때 poll()해도 예외가 발생하지 않는다
		q.poll();
		
	}

}
