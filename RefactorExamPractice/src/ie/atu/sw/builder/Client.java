package ie.atu.sw.builder;

public class Client {
	
	public static void main(String[] args) {
		User newUser1 = new User.Builder("Fionn", "McGoldrick")
				.age(23).gender("Male").height(5.11f).build();
		
		newUser1.displayName();
		
		User newUser2 = new User.Builder("Tom", "Nook").age(50).build();
		newUser2.displayName();
	}
}