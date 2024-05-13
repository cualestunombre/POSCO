package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("5개의 숫자를 입력하세요");
		double sum = 0;
		
		for (int i = 0 ; i < 5 ; i++) {
			sum += scanner.nextDouble();
		}
		
		System.out.println("평균은 "+ sum/5 + " 입니다.");
		
		
	

	
		scanner.close();
	}
}
