package ie.atu.sw;

import static java.util.Objects.*;

import java.util.UUID;

public record Ticket(String id, Concert concert, Attendee attendee, double price, String advisory) {

	public Ticket(Concert concert, Attendee attendee, double price, String advisory) {
		this(UUID.randomUUID().toString(), concert, attendee, price, advisory);
	}
	
	public Ticket{
		requireNonNull(id);
		requireNonNull(concert);
		requireNonNull(attendee);
		requireNonNull(advisory);
		
		//RULES
		//A ticket may be free but not negative number
		if(price < 0) {
			throw new IllegalStateException("Ticket price cannot be negative");
		}
	}
}
