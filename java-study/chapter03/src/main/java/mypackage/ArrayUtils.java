package mypackage;

public class ArrayUtils {
	
	public static double[] intToDouble(int[] source) {
		double[] ret = new double[source.length];
		for (int i = 0 ; i < source.length; i++) {
			ret[i] = (double)i;
		}
		return ret;
	}
	
	public static int[] doubleToInt(double[] source) {
		int[] ret = new int[source.length];
		for (int i = 0 ; i < source.length; i++) {
			ret[i] = (int)i;
		}
		return ret;
	}
	
	public static int[] concat(int[]s1, int[] s2) {
		int[] ret = new int[s1.length + s2.length];
		for (int i = 0 ; i < s1.length; i++) {
			ret[i] = s1[i];
		}
		for (int i = 0 ; i < s2.length; i++) {
			ret[i+s1.length] = s2[i];
		}
		return ret;
	}

}
