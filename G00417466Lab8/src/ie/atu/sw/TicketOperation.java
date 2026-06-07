package ie.atu.sw;

import java.util.Collection;
import java.util.function.Predicate;

//Sealed type - representing a suite of choices we can make
public sealed interface TicketOperation {

	//These 3 records effectively describe actions/operations and how to do them or who is doing them
	//These will be passed to a method
	record Purchase(Attendee attendee, Concert concert, double price) implements TicketOperation {};
	//This one in particular is meant to demonstrate something that is flexible/can handle anything
	//i.e. what type of concert
	//To do this we use a "predicate" which is like a lambda expression
	record Search(Collection<Concert> concerts, Predicate<Concert> criteria) implements TicketOperation {};
	record Advisory(Venue venue) implements TicketOperation {};
}
