package behavioral.strategy;

public class Client {

	public static void main(String[] args) {
		new CalculateContext().execute((a,b)-> a+b);
		new CalculateContext().execute((a,b)-> a*b);
	}

}
