package chapter04;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(now);
		System.out.println(date);
		
		printDate02(now);
		
	}
	
	public static void printDate02(Date now){
		
		// 년도 + 1900을 더해야한다
		System.out.println(now.getYear());
		
		// 월 + 1을 더해야한다
		System.out.println(now.getMonth());
		
		System.out.println(now.getDate());
		
		// 시
		System.out.println(now.getHours());
		
		// 분
		System.out.println(now.getMinutes());

		// 초
		System.out.println(now.getSeconds());
				
	}

}
