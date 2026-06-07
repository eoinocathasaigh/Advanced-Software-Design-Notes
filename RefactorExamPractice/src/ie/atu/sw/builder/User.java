package ie.atu.sw.builder;

public class User {
	private String firstName;
	private String secondName;
	private int age;
	private String gender;
	private float height; 
	
	
	public User(Builder builder) {
		this.firstName = builder.firstName;
		this.secondName = builder.secondName;
		this.age = builder.age;
		this.height = builder.height;
		this.gender = builder.gender;
	}
	
	public void displayName() {
		System.out.println("Name: " + this.firstName + " " + this.secondName);
	}
	
	//BUILDERS ARE OFTEN NESTED CLASSES
	public static class Builder {
		
		private String firstName;
		private String secondName;
		private int age;
		private String gender;
		private float height; 
		
		public Builder(String firstName, String secondName) { //required fields
			this.firstName = firstName;
			this.secondName = secondName;
		}
		
		//Getters for other params
		public Builder age(int age) {
			this.age = age;
			return this; //returns current instance of builder which allows chaining

		}
		
		public Builder height(float height) {
			this.height = height;
			return this;
		}
		
		public Builder gender(String gender) {
			this.gender = gender;
			return this;
		}
		
		public User build() {
			return new User(this);
		}

		
	}

}