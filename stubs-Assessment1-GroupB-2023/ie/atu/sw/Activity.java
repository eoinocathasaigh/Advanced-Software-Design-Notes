package ie.atu.sw;

public enum Activity {
	NONE 			(2.0d, 	"No risk"),
	LOW 			(4.0d, 	"Low risk"),
	MEDIUM 			(5.0d, 	"A slight risk"),
	ELEVATED 		(6.0d, 	"Moderate risk"),
	HIGH 			(16.0d, "High risk"),
	VERY_HIGH 		(42.0d, "Very high risk");

	private double level;
	private String desc;
	
	Activity(double level, String description) {
		this.level = level;
		this.desc = description;
	}

	public double level() {
		return level;
	}

	public String description() {
		return desc;
	}
}