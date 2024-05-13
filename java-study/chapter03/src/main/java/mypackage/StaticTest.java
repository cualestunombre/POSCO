package mypackage;

public class StaticTest {
	
	int n;
	static int m;
	
	static void s1() {
		
		// n = 10; 인스턴스 변수 접근 불가능
		
	}

	static void s2() {
		
		// f1(); 인스턴스 메소드 접근 불가능
	}
	
	static void s3() {
		
		// 같은 클래스의 클래스 변수 접근 가능, 클래스 이름 생략 가능
		
		StaticTest.m = 10;
		
		m = 10 ;
		
	}
	
	static void s4() {
		// 같은 클래스의 클래스 메서드 접근 가능, 클래스 이름 생략 가능
		
		StaticTest.s1();
		
		s1();
	}
	
	void f2() {
		
		// static 변수 접근 가능
		
		StaticTest.m = 10;
		m = 20;
		
	}
	
	void f3() {
		
		f2();
		
	}

	void f4() {
		
		// 같은 클래스의 클래스 메소드 접근에서는 클래스 이름 생략 가능
		
		StaticTest.s1();
		
		s1();
		
	}
	
	
}
