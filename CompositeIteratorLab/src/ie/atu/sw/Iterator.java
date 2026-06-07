package ie.atu.sw;

/*
 *  An iterator is an abstract policy for sequentially
 *  traversing a complex data structure.
 */
public interface Iterator<E> {
	public boolean hasNext();
	public E next();
}