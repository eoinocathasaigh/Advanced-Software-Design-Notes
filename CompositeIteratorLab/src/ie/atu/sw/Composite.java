package ie.atu.sw;

/*
 * Composite’s role is to define behaviour of the components 
 * having children and to store child components.
 */
import java.util.Arrays;

//Plays role of composite type in the control pattern
//Extends node - is a node
//Has a node list - has a node
public class Composite<E> extends Node<E>{
	private Node<E>[] elements; //A container for elements
	private int size = 0; //The number of elements

	@SuppressWarnings("unchecked")
	public Composite(E data) {
		super(data);
		elements = new Node[1]; //Initialise array
	}

	public void addChild(Node<E> e) { //Add child
		ensureCapacity();
		elements[size] = e;
		size++;
	}

	public void removeChild(Node<E> e) { //Search and remove child
		remove(indexOf(e)); 
	}
	
	private void remove(int index) { //Remove from an index
		checkRange(index);
		elements[index] = null;
		elements[size - 1] = null;
		size--;
	}

	public Node<E>[] children() {
		return (Node<E>[]) elements;
	}
	
	public boolean hasChild(Node<E> e) { //Search for an child
		return indexOf(e) >= 0; 
	}
	
	public int childCount() {
		return size;
	}
	
	private int indexOf(Node<E> e) { //Search for an element index
		if (e != null) {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(e)) return i;
			}
		}
		return -1;
	}
	
	private void checkRange(int index) {
		if (index >= elements.length) throw new ArrayIndexOutOfBoundsException();
	}

	private void ensureCapacity() {
		if (elements.length <= size) elements = Arrays.copyOf(elements, size + 1);
	}
}