package ie.atu.sw;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.*;

public record Attendee(String id, String name, String email, List<Ticket> tickets) {

	public Attendee(String name, String email, List<Ticket> tickets) {
		//We use copyOf to make sure things are mutable and read-only
		this(UUID.randomUUID().toString(), name, email, List.copyOf(tickets));
	}
	
	//Needs to have same visibility as constructor
	public Attendee{
		requireNonNull(id);
		requireNonNull(name);	
		requireNonNull(email);
		//Need to check if the list of tickets is emutable
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Attendee other) {
			return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
		}else {
			return false;
		}
	}
}
