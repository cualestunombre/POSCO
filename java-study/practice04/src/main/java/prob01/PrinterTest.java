package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
		
		Printer<String> printer2 = new Printer<>();
		printer2.println("adsd", "sdsdsd");
		System.out.println(printer.sum(1,2,3,4,5));
	}
}