package ie.atu.sw.factory;

public class Client {	
	public static void main(String[] args) {
		//composition
		Drinkable drink1 = new Water();
		Drinkable drink2 = new Coffee();
		
		//Gun gun1 = new Gun();

		//factory
		Drinkable s = DrinkFactory.getDrink(Drinks.COFFEE);
		
		s.drink();
	}
}