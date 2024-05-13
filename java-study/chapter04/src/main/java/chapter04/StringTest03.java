package chapter04;

import java.util.Arrays;

public class StringTest03 {
	
	public static void main(String[] args) {
		String s1 = "Hello " + "World " + " java" + 17;
		// new StringBuffer("Hello").append(" World").append(" java").append(17).toString() 동일한 코드다
		String s2 = "";
		
//		for (int i = 0 ; i < 1000000 ; i++) {
//			System.out.println(i);
//			s2 = s2 + "h";
//			// s2 = new StringBuilder(s2).append("h").toString();
//		}
		// 메모리 할당으로 인해 매우 오래걸린다
		
		StringBuffer sb = new StringBuffer("");
		for (int i = 0 ; i < 1000000 ; i++) {
			sb.append("h");
		}
		// 별로 오래걸리지 않는다
		
		String s4 = "ABcABCabacABC";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("ab"));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3,5));
		
		String s5 = "    ab    cd    ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		// trim() -> 양 옆으로 공백을 없앤다
		System.out.println("----" + s5.trim() + "----");
		System.out.println("----" + s5.replaceAll(" ","") + "----");
		
		Arrays.stream(s6.split(",")).forEach(System.out::println);
		
		// 짤라낼 것이 없으면 하나 큰게 나온다
		Arrays.stream(s6.split(" ")).forEach(System.out::println);
	}

}
