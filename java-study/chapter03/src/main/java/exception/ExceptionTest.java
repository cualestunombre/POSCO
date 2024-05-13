package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		
		try {
			
			int a = 10 / 0;
			
		}catch(Exception e) {
			
			/* 예외 처리 */
			
			// 1. 로깅
			System.out.println("예외 발생");
		
			// 2. 사과
			System.out.println("미안합니다...");
			
			// 3. 정상종료 - JVM에 1전달
			System.exit(1);
			
		}finally {
			// 반드시 실행되는 구문
			// 자원정리를 하는 부분
			
		}
		
		
		
		
		
	}
}
