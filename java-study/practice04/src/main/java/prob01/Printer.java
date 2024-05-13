package prob01;

import java.util.Arrays;

public class Printer<T> {
	public void println(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static <T> void print(T t) {
		System.out.println(t.toString());
	}
	
	public <T,S> S println(T t, S s) {
		return s;
	}
	
	public int sum(Integer... numbers) {
		return Arrays.stream(numbers)
			.reduce(0, (s,e)->s+e);
	}
	
	// static <T> void sort(List<T> list, Comparator<? super T> c) {}
}
