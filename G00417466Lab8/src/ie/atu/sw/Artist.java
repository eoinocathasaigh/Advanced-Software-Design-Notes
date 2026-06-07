package ie.atu.sw;

//Need this statement to implement the operations
import static java.util.Objects.*;

import java.util.UUID;

//We're going to use the "canonical constructor" to set the fields
public record Artist(String id, String name, Genre genre) {
	
	//An enum to handle the various "genre" values that could be chosen
	enum Genre {BLUES, COUNTRY, FOLK, HIP_HOP, JAZZ, METAL, POP, PUNK, ROCK, SOUL}
	
	//Overloading the constructor - this is the one people will ideally use
	public Artist(String name, Genre genre) {
		this(UUID.randomUUID().toString(), name, genre);
	}
	
	//Logically this is the same as the very top constructor
	public Artist{
		//Specifying that none of these fields can be null
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(genre);
	}

}
