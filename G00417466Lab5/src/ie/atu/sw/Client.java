package ie.atu.sw;

/* 
 * The Client class has dependencies on the target interface SequenceListStore and
 * on the Adapters InhStoredSequenceListAdapter and ComStoredSequenceListAdapter. 
 * However, the "Class Adapter" InhStoredSequenceListAdapter also places a transitive
 * dependency on the class StoredSequenceContext. 
 * 
 * The client knows nothing about the state abstraction (SequenceComparator) or any 
 * of the different concrete state objects (subtypes of SequenceComparator). If a 
 * Strategy Pattern had been used, the client would have been responsible for configuring
 * the context (StoredSequenceContext) with a concrete strategy and would therefore have
 * to know about, and have possible dependencies on, the classes Hamming, SmithWaterman,
 * Levenshtein and DamerauLevenshtein.
 */
public class Client {
	public static void main(String[] args) throws Exception{
	     CharSequence[] sequences = {"Galvia", "Galloway", "Galaxy", "Always", "Gorgon"}; 
	     
	     //We do not have a conforming class yet
	     SequenceListStore sls = new InhStoredSequenceListAdapter("Galway");
	     sls.open("./out.txt");
	     sls.store(sequences);
	     sls.close();
	     
	     //These ways demonstrate using class adapters as opposed to object adapters - this can give us visibility/inheritance issues in the future
	     //Its better for us to use object adapters
	     
	     //Inheritance hierarchy is clearer here - makes it harder to change things at compile time
	     //Can infer that youre transitively inheriting from InhStoredSequenceContext
	     //But you cant see it with the object version - it is encapsulated
	     InhStoredSequenceListAdapter adapt = (InhStoredSequenceListAdapter) sls;
	     StoredSequenceContext ssc = new InhStoredSequenceListAdapter("Galway");
	     
	     //OBJECT ADAPTER
	     //Usage is almost identical - this time its just done using composition as opposed to inheritance
	     //This way we cant be treated like anything other than the target interface
	     //Even if we try and change the definition we only have access to the defined methods
	     //More flexible too - look at CommStored.. for details on that
	     SequenceListStore sls1 = new ComStoredSequenceListAdapter("Galway");
	     sls1.open("./out1.txt");
	     sls1.store(sequences);
	     sls1.close();
	     
	     //FAVOUR COMPOSITION OVER INHERITANCE 
	     
	     /*
	      * SEALED TYPES - WHEN WOULD YOU USE THEM?
	      * TO limit usage of something
	      * Sometimes we have a Bounded system/architecture - we know exactly how many things we have got
	      * Sealed types are good for restricting what we've got i.e. we have in inheritance hierarchy here of stuff inheriting other stuff
	      * Marking something as "unsealed" is like a get out of free card but it means you've got done something wrong
	      * 
	      * Design patterns made for stopping a class explosion:
	      * 1. Adopter - object over class adopter
	      * 2. Decorator 
	      * 3. Bridge Pattern
	      * 
	      * Best way to store properties - enum - like states 
	      * 
	      * DOP - ALGEBRAIC TYPES WILL BE IN ASSESSMENT 2 a lot
	      * DATA ORIENTED PROGRAMMING
	      * 
	      * WHAT IS A CLASS EXPLOSION
	      * E.G. When a class is abstracted too much/ abstracted incorrectly
	      * Ways to get around it:
	      * 1. Bridge
	      * - Class A with a bunch of stuff attached to it - sum of its classes
	      * - Class B with a bunch of stuff attached to it - sum of its classes
	      * - Put a bridge between them - bridging 2 inheritance hierarchies
	      * - Linked by composition
	      * 
	      * 2. Decorator
	      * - Again creating 2 hierarchies - uses composition again for decorator
	      * - The decorator 
	      * 
	      * 3. Adopter
	      * - Lots of types of A & B
	      * - We put an adopter in the middle and it will be composed of A & B
	      * - Allows them to talk to each other
	      * - 
	      * */
	     
	}
}