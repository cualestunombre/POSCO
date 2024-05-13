package prob01;

import java.util.Arrays;
import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner( System.in  );
		System.out.print("금액: ");
		
		int amount = scanner.nextInt();
	

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int [] cand = new int[10];

		for (int i = 0 ; i < MONEYS.length; i++) {
			
			if (amount >= MONEYS[i]) {
				cand[i] = (int) (amount / MONEYS[i]);
				amount -= MONEYS[i] * cand[i];
			}
			
		}
		
		for (int i = 0 ; i < MONEYS.length; i++) {
					
					System.out.println(MONEYS[i]+"원 : " + cand[i]+"개");
				
		}
		
		scanner.close();
 	}
}