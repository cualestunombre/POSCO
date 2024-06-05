package behavioral.templatemethod;

public class Client {

	public static void main(String[] args) {
		new Calculator().add();
		new Calculator().substract();
		
		new DevideCalculation().templateMethod();
		new MultiplyCalculation().templateMethod();
	}

}
