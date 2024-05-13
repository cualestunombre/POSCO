package chapter04;

import java.util.Calendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		// 시스템에 잡혀있는 Locale을 기반으로 달력을 선택한다
		Calendar calendar = Calendar.getInstance(); // 팩토리 메서드 패턴
		
		
		
		System.out.println(calendar);
		
		printDate(calendar);
		
		calendar.set(Calendar.YEAR, 2024); // 2024년 설정
		calendar.set(Calendar.MONTH, 11); // 12월 설정
		calendar.set(Calendar.DATE, 25); // 25일 설정
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		
		calendar.set(2023, 11,4);
		calendar.add(Calendar.DATE,177);
		printDate(calendar);
				
	}
	
	private static void printDate(Calendar cal) {
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		System.out.println(day);
	}

}
