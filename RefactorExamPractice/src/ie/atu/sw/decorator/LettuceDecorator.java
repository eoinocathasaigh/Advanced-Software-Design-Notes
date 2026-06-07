package ie.atu.sw.decorator;

public class LettuceDecorator extends SandwichDecorator {
	
	public LettuceDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	@Override
	public String make() {
		return customSandwich.make() + " + Lettuce";
	}
}