package observer;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Subject<Integer> subject = new Subject<>();
		
		subject.registerObserver((a)->System.out.println("Observer01:" + a));
		
		subject.registerObserver((a)->System.out.println("Observer02:" + a));
		
		try(Scanner scanner = new Scanner(System.in);){
			while (true) {
				int retVal = scanner.nextInt();
				if (retVal < 0) break;
				subject.changeSubject(retVal);
			}
			
			
		}
	}
	
}
