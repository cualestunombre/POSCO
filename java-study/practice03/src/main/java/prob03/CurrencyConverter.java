package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		// 한국 원화를 달러로 변환
		return won / rate;
	}
	
	public static double toKRW(double dollar) {
		return dollar * rate;
	}
	
	public static void setRate(double r) {
		rate = r; // krw / dollar
	}
	
	

}
