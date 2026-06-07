package ie.atu.sw.decorator;

public class Client {

	public static void main(String[] args) {
		Sandwich sandwich = new BasicSandwich(); // Bread
		sandwich = new CheeseDecorator(sandwich); // Bread + Cheese
		sandwich = new LettuceDecorator(sandwich); // Bread + Cheese + Lettuce
		sandwich = new SauceDecorator(sandwich); // Bread + Cheese + Lettuce + Sauce
		
		System.out.println(sandwich.make());

	}
}
