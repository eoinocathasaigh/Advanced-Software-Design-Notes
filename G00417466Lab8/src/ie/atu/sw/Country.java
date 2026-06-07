package ie.atu.sw;

public enum Country {
	BELGIUM 		(11.98,		749, 	true),
	FRANCE			(13.16,		0645, 	true),
	GERMANY			(10.83,		613, 	true),
	GREECE			(14.88,		549, 	true),
	HUNGARY 		(12.62,		503, 	true),
	ICELAND			(2.110,		1288, 	false),
	IRELAND			(10.35,		1153, 	true),
	ITALY			(14.38,		601, 	true),
	LATVIA			(7.400,		639, 	true),
	MALTA			(20.26,		393, 	true),
	POLAND			(9.700,		541, 	true),
	PORTUGAL		(16.90,		844, 	true),
	SPAIN			(15.30,		551, 	true),
	SWITZERLAND		(8.080,		1054, 	false),
	SWEDEN			(3.840,		604, 	true),
	RUSSIA			(-2.87,		500, 	false),
	UNITED_KINGDOM	(10.11,		1124,	false);
	
	private final double temperature;	//Average temperature in degrees celsius
	private final double precipitation; //Average rainfall in mm
	private final boolean euMember; 	//A member state of the EU
	
	Country(double temperature, double precipitation, boolean euMember) {
		this.temperature = temperature;
		this.precipitation = precipitation;
		this.euMember = euMember;
	}

	public double temperature() {
		return temperature;
	}

	public double precipitation() {
		return precipitation;
	}
	
	public boolean isEUMember() {
		return euMember;
	}
}