package chapter03;

public class SwapTest01 {
	
	public static void main(String[] args) {
		
		int i = 10;
		int tmp;
		int j = 20;
		
		
		System.out.println(i + ", " + j);
		
		swap(i,j);
		
		System.out.println(i + ", " + j);
			
	}
	
	/*
	 * CALL BY VALUE로 동작하기 때문에 SWAP 함수 사용이 불가능하다
	 */
	
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
}
