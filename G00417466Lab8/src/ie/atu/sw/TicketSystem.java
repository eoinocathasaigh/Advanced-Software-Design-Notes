package ie.atu.sw;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//This class will actually implement our ticketing system
//It will consist of a list of stateless methods - representing the processes
//This is ultimately what DOP is all about - separating data from processing/behaviour 
public class TicketSystem {
	
	//Variable for handling the defined value for raining & precipitation levels etc
	private static final double RAIN_VAL = 13.00d;
	private static final int PRECIPITATION = 1000;
	private static final int MAX_VENUE_CAPACITY = 10_000;

	//We're going to implement 2 of each of these methods - one will be the analogue operation
	//Method overloaing
	public static Ticket purchase(TicketOperation.Purchase pur) {
		return purchase(pur.attendee(), pur.concert(), pur.price());
	}
	
	public static Ticket purchase(Attendee attendee, Concert concert, double price) {
		//Need to change/fix this - we'll do it last
		var advisory = advisory(new TicketOperation.Advisory(concert.venue()));
		return new Ticket(concert, attendee, price, advisory);
	}
	
	//Search functions
	public static Collection<Concert> search(TicketOperation.Search sch) {
		return search(sch.concerts(), sch.criteria());
	}
	
	public static Collection<Concert> search(Collection<Concert> concerts, Predicate<Concert> criteria) {
		return concerts.stream().filter(criteria).collect(Collectors.toList());
	}
	
	//Advisory
	//Case we need to handle is if we arent returning a string value
	public static String advisory(TicketOperation.Advisory adv) {
		//This will return an optional to us - since its an object we can check to see if it has a value
		var opt = advisory(adv.venue());
		
		return opt.isPresent() ? opt.get() : "Enjoy the Concert.";
	}
	
	//What is an optional - means we handle if its not a string
	public static Optional<String> advisory(Venue venue) {
		var sb = new StringBuilder();
		
		//Bring a passport if travelling
		if (venue.country().isEUMember()) sb.append("Bring a passport if travelling");
		
		//Bring light clothing if temp is a certain value
		if(venue.country().temperature() >= RAIN_VAL) sb.append("Bring light clothing");
		
		//Bring waterproof clothing if raining etc
		if(venue.country().precipitation() >= PRECIPITATION) sb.append("Bring waterproof clothing");
		
		//Checking the venue capacity
		if(venue.capacity() > MAX_VENUE_CAPACITY) sb.append("Large Crowds Expected");
		
		//Then need to switch over the venue type to check for tiered seating
		sb.append(
		switch(venue.type()) {
			case AMPHITHEATER, ARENA, STADIUM -> "This venue contains tiered seating";
			default -> "";
		});
			
		return sb.length() > 0 ? Optional.of(sb.toString()) : Optional.of(null);
	}
}
