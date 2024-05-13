package prob06;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CalcApp {
	private final static Map<String, Arithmetic> opMap = Map.of("+",new Add(),"-",new Sub(),"*",new Mul(),"/",new Div());


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			/*  코드를 완성 합니다 */
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 2 ] );
			
			Arithmetic arith = opMap.get(tokens[1]);
			
			if (arith == null) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			arith.setValue(lValue, rValue);
			Number result = arith.calculate();
			System.out.println( ">> " + result );
			

		}
		scanner.close();
	}

}
