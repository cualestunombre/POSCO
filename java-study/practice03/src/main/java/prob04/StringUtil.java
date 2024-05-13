package prob04;

import java.util.Arrays;

public class StringUtil {
	public static String concatenate(String[] str) {
		// 문자열을 결합하 리턴하는 메서드
		return Arrays.stream(str)
				.reduce("", (s,o)-> s+o);
	}
}
