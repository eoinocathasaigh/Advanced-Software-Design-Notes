package ie.atu.sw;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;

import static java.lang.System.*;

//This class has no strange or embedded queries
public class Runner {
	private EmbeddedStorageManager db = null; // The storage manager is the database...
	private List<Customer> root = new ArrayList<>(); //The "root" of our database can be any type of object
	
	//Main starting method 
	//We create the instance of the customer factory and get a customer list
	//We then save the graph to the db - all root dependencies
	//We then execute some read-only queries
	//Root is nothing more than a list of customers
	public void go() {
		root = CustomerListFactory.getInstance().getCustomerList(); //Initialise the database. Comment out after first use
		db = EmbeddedStorage.start(root, Paths.get("./data")); 
		db.storeRoot(); //Save the object graph to the database, i.e. the root and all dependencies
		query(); //Execute some read-only queries (SELECT equivalents)
		//update(); //Change object state and save by calling store(obj) or storeRoot() 
		db.shutdown(); //Shutdown the db properly
	}
	
	/*
	 * Some basic CRUD operations. No need for XPath, XQuery, OQL, HQL and definitely not SQL.
	 * The streaming API may well be pointing to the future of data / database query languages.
	 */
	private void query() { 
		//Query 1: Show all customers.
		out.println("\n[Query 1] Show all customers");
		root.stream().forEach(out::println);;
			
		//Query 2: Show all customers ordered by name.
		out.println("\n[Query 2] Show all customers ordered by name");
		root.stream()			
		    .sorted((s, t) -> s.getName().compareTo(t.getName())) //Sort with a lambda expression
		    .sorted(Comparator.comparing(Customer::getName)) //Sort with a method reference
		    .forEach(out::println);
		
		//Query 3: Show all customers whose name starts with 'M' in descending order.
		out.println("\n[Query 3] Show all customers whose name starts with 'M' in descending order.");
		root.stream()
		    .filter(c -> c.getName().startsWith("M")) //A filter takes a predicate (like a native method)
		    .sorted(Comparator.comparing(Customer::getName).reversed()) //Use Comparator.reverseOrder() to reverse natural ordering.
		    .forEach(out::println);
		
		//Query 4: Show the set of customer names in a linked list
		out.println("\n[Query 4] Show the set of customer names in a linked list.");
		var names = root.stream()
						.map(c -> c.getName())
						.distinct()
						.collect(Collectors.toCollection(LinkedList::new));		
		out.println(names);
		
		//Query 5: Show all customer numbers and their orders 
		out.println("\n[Query 5] Show all customer numbers and their orders.");
		var map = root.stream()
					  .collect(Collectors.toMap(Customer::getNumber, Customer::orders));
		out.println(map); //Outputs a Map<String, Collection<Order>>
			
		//Query 6: Show all Customers with orders for Galway	
		out.println("\n[Query 6] Show all Customers with orders for Galway.");
		root.stream()
		    .filter(n -> n.orders().stream() 
		    .anyMatch(m -> m.getShipTo().county() == County.GALWAY))
		    .forEach(out::println);
		
		//Query 7: Show all Customers with orders after 1/11/2019
		out.println("\n[Query 7] Show all Customers with orders after 1/11/2019.");
		root.stream().forEach(n -> n.orders()
									.stream()
				                    .filter(m -> m.getDate().isAfter(LocalDate.of(2023, 11, 1)))
				                    .map(o -> o.getNumber())
				                    .forEach(out::println)
		);

		//Query 8: Show the name and status of all customers with more than one orders with a map
		out.println("\n[Query 8] Show the name and status of all customers with more than one orders with a map");
		root.stream()
		   .filter(n -> n.size() > 1) //Apply restriction (WHERE)
		   .collect(Collectors.toMap(Customer::getName, Customer::getStatus)) //Collection to a map 
		   .entrySet() //Get the key-value set
		   .forEach(e -> out.println(e.getKey() + "=>" + e.getValue())); //Output key-value pairs
		
		//Query 9: Show the name and status of all customers with more than one orders with a formatted string
		out.println("\n[Query 9] Show the name and status of all customers with more than one orders with a formatted string");
		root.stream()
		   .filter(n -> n.size() > 1) //Apply restriction (WHERE)
		   .map(n -> String.format( "%s=>%s", n.getName(), n.getStatus())) //Format a string for output
		   .forEach(out::println); //Output key-value pairs
		
		//Exercise queries
		// Show all Customers with a status of RECURRING
		out.println("\n[Query 10] Show all Customers with a status of RECURRING");
		root.stream()
		    .filter(c -> c.getStatus().equals(CustomerStatus.RECURRING))
		    .forEach(out::println);
		
		// Show all Orders with a value of more than 1000
		out.println("\n[Query 11] Show all Orders with a value of more than 1000");
		root.stream()
		    .filter(n -> n.orders().stream() 
		    .anyMatch(m -> m.getShipTo().county() == County.GALWAY))
		    .forEach(out::println);
		
		// Show all Order Items that start with an Order Number of QB-10
		out.println("\n[Query 12] Show all Order Items that start with an Order Number of QB-10");
		root.stream().forEach(n -> n.orders()
									.stream()
				                    .filter(m -> m.getNumber().startsWith("QB-10"))
				                    .map(o -> o.getNumber())
				                    .forEach(out::println)
		);
	}
	
	public void update() {
		//Update the Customer with the number c1
		out.println("\n[Update] Modifying the Customer with the number c1");
		var c = root.stream()
					.filter(n -> n.getNumber().equalsIgnoreCase("c1"))
					.collect(Collectors.reducing((a, b) -> null))
					.get();
		out.println(c);
		c.setName("Patrick O'Neill");
		out.println(c);
		db.store(c);
		
		//Delete
		//root.clear();
		//db.storeRoot();
	}
	
	public static void main(String[] args) {
		new Runner().go();
	}
}