package chapter03;

import mypackage.Value;

public class SwapTest03 {

	
	public static void main(String[] args) {
			
			Value i = new Value(10);
			
			Value j = new Value(30);
			
			
			System.out.println(i.val + ", " + j.val);
			
			swap(i,j);
			
			System.out.println(i.val + ", " + j.val);
				
		}
		
		/*
		 * CALL BY REF로 동작하기 때문에 SWAP 함수 사용이 가능하다
		 */
		
		public static void swap(Value a, Value b) {
			
			int temp = a.val;
			a.val = b.val;
			b.val = temp;
			
		}

}
