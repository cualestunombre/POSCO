package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 30, 20, 19, 8, 11, 20, 1 };
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		
		sort(array);
		
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
	
	public static void sort(int array[]) {
		for (int i=0 ; i < array.length ; i++) {
			for (int j = 0 ; j < array.length - 1 ; j ++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}