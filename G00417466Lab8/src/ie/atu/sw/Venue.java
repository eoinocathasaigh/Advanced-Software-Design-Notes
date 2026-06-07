package ie.atu.sw;

import java.util.UUID;
import static java.util.Objects.*;

public record Venue(String id, String name, VenueType type, Country country, int capacity) {
	
	//Static variable for the minimum capacity needed
	public static final int MIN_CAPACITY = 100;
	
	public Venue(String name, VenueType type, Country country, int capacity) {
		this(UUID.randomUUID().toString(), name, type, country, capacity);
	}
	
	public Venue{
		requireNonNull(id);
		requireNonNull(name);
		//Enums can be null since they're objects so we need to treat them as such
		requireNonNull(type);
		requireNonNull(country);
		
		//Can't perform the non null on capacity so we need to perform this check on it
		//Venue capacity must be at least 100
		if(capacity < MIN_CAPACITY) {
			throw new IllegalStateException("Capacity must be at least 100");
		}
	}
}
