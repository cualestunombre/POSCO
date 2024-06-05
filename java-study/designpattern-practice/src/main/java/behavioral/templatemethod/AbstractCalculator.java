package behavioral.templatemethod;

import java.util.Scanner;

public abstract class AbstractCalculator {
	
	public void templateMethod() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(val1,val2) > ");
		
		int val1 = scanner.nextInt();
		int val2 = scanner.nextInt();
		
		int result = calculate(val1,val2);
		
		System.out.println(result);
	}
	
	abstract public int  calculate(int val1, int val2);

}
