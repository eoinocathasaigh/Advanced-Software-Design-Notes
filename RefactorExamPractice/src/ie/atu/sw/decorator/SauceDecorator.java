package ie.atu.sw.decorator;

public class SauceDecorator extends SandwichDecorator {
	
	public SauceDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	@Override
	public String make() {
		return customSandwich.make() + " + Sauce";
	}
}