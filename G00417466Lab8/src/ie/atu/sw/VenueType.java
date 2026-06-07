package ie.atu.sw;

public enum VenueType {
	AMPHITHEATER		("An outdoor venue that features a central oval space surrounded by elevated seating."),
	ARENA				("A level area surrounded by seating."),
	THEATRE				("A building or outdoor area in which plays and other dramatic performances are given."),
	STADIUM				("An athletic or sports ground with tiers of seats for spectators."),
	CONFERENCE_CENTRE	("A large building that is designed to hold a convention"),
	CLUB				("A venue that features the playing fashionable dance or other music."),	
	OPERA_HOUSE			("An indoor venue that features a stage, an orchestra pit, audience seating and backstage facilities."),
	NOT_SPECIFIED		("Not specified.");
	
	private final String description;

	VenueType(String description){
		this.description = description;
	}
	
	public String description() {
		return description;
	}
}