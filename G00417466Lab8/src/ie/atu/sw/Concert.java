package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record Concert(String id, Artist artist, LocalDateTime date, Venue venue) {

	public Concert(Artist artist, LocalDateTime date, Venue venue) {
		this(UUID.randomUUID().toString(), artist, date, venue);
	}
	//Validation is done using the canonical constructor
	public Concert{
		requireNonNull(id);
		requireNonNull(artist);
		requireNonNull(date);
		requireNonNull(venue);
		
		//Concert must be some time in the future
		if(date.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("Concert must be some time in the future");
		}
	}
}
