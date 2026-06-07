package ie.atu.sw.decorator;

public class CheeseDecorator extends SandwichDecorator {
	
	public CheeseDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}
	
	@Override
    public String make() {
        return customSandwich.make() + " + Cheese";
    }

}