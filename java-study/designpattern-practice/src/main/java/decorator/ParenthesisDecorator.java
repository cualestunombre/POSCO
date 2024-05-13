package decorator;

public class ParenthesisDecorator extends Decorator {
	public ParenthesisDecorator(Component component) {
		super(component);
	
	}

	@Override
	public String operation() {
		return "(" + super.component.operation() + ")";
		
	}
}
