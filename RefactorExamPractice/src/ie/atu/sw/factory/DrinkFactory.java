package ie.atu.sw.factory;

public class DrinkFactory {
	public static Drinkable getDrink(Drinks type) {
		switch(type) {
		case WATER:
			return new Water();
		case COFFEE: 
			return new Coffee();
		}
		return null;
		
	}
}