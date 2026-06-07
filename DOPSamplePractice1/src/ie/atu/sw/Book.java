package ie.atu.sw;

import static java.util.Objects.requireNonNull;
import java.util.UUID;

public record Book(String id, String title, String author, int isbn, int availableCopies) {

	//Declaring a list variable to be able to handle the List of borrowed history
	
	//Declaring constructors for this class
	public Book(String title, String author, int isbn, int availableCopies) {
		this(UUID.randomUUID().toString(), title, author, isbn, availableCopies);
	}
	
	public Book{
		requireNonNull(id);
		requireNonNull(title);	
		requireNonNull(author);
		requireNonNull(isbn);
		requireNonNull(availableCopies);
	}
}
