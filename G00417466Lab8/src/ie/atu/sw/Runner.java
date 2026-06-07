package ie.atu.sw;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		var artist = new Artist("Queen", Artist.Genre.ROCK);
		var venue = new Venue("Croke Park", VenueType.STADIUM, Country.IRELAND, 80_000);
		var concert = new Concert(artist, LocalDateTime.of(2025, 12, 8, 20, 30), venue);
		var attendee = new Attendee("John Doe", "John.Doe@atu.ie", List.of());
		var ticket = TicketSystem.purchase(new TicketOperation.Purchase(attendee, concert, 79.99));
		System.out.println(ticket);
		
		Collection<Concert> res = TicketSystem.search(new TicketOperation.Search(List.of(concert),
		(con -> con.date().isBefore(LocalDateTime.of(2025, Month.DECEMBER, 24, 22, 00)))));
		System.out.println(res);
		
		//Records are immutable, so we have to re-construct a new record to update
		var tmp = new ArrayList<Ticket>();
		tmp.addAll(attendee.tickets());
		tmp.add(ticket);
		attendee = new Attendee(attendee.name(), attendee.email(), tmp);

	}

}
