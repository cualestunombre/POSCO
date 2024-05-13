package decorator;

public class Client {
	
	public static void main(String[] args) {
		System.out.println(new ConcreteComponent("Hello World").operation());
		System.out.println(new BraceDecorator(new ConcreteComponent("Hello World")).operation());
		System.out.println(new ParenthesisDecorator(new ConcreteComponent("Hello World")).operation());
		System.out.println(new BraceDecorator(new ParenthesisDecorator(new ConcreteComponent("Hello World"))).operation());
	}

}

