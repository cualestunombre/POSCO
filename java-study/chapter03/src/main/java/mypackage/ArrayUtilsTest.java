package mypackage;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtilsTest {
	public static void main(String[] args) {
		
		int[] a = {10, 20, 30, 40};
		
		double[] d = ArrayUtils.intToDouble(a);
		Arrays.stream(d).forEach(System.out::println);
		
		int[] n = ArrayUtils.concat(new int[] {1,2,3,4,5},new int[] {6,7,8,9});
		
		Arrays.stream(n).forEach(System.out::println);
		
		
	}

}
