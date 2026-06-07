package ie.atu.sw;

import java.util.*;

//Behaves as a data structure/wrapper for our nodes
public class Tree<E> {
	private Composite<E> root;
	
	public Tree(Composite<E> root) {
		super();
		this.root = root;
	}

	public void add(Node<E> child, Composite<E> parent) {
		parent.addChild(child);
	}
	
	/*
	 * Return a concrete iterator capable of traversing the collection
	 */
	//We call iterator on type aggregate
	//Treeiterator is our concrete iterator
	public Iterator<E> iterator(){
		return new TreeIterator<E>(root);
	}
	
	
	/*
	 *  The concrete iterator is independent of the data structure that
	 *  it traverses and encapsulates the behaviour (SRP). This inner
	 *  class could be moved into its own file, but for the sake of 
	 *  encapsulation inside the class Tree.
	 */
	//Could move this elsewhere 
	//In this case it does make sense for it to be internal since we want to observe behaviour of iterator
	//Is this a breach of srp? no its stored in its own private class, just internally
	//Could alternatively move it to its own class
	//But we dont do this because we want to mask the iterator
	private class TreeIterator<T extends E> implements Iterator<E>{
		/*
		 * We can do LIFO or FIFO operations with a dequeue
		 */
		private Deque<Node<E>> deque = new ArrayDeque<>();

		/*
	     * The iterator is responsible for keeping track of the 
	     * current element during traversal.
	     */
		private Node<E> current;

	    
		public TreeIterator(Node<E> node) {
	    	deque.push(node); //We're LIFO!
	    }
	    
	    /*
	     * Traversal is implemented here in depth-first order, but it
	     * can be changed to traverse the data structure sequentially in
	     * any way we like, including supporting filtering operations. 
	     */
	    private void enqueue(Node<E> node) {
	    	if (node.childCount() > 0) {
	    		Composite<E> com = (Composite<E>) node;
	    		Node<E>[] children =  com.children();
	    		for (Node<E> child : children) {
	    			deque.push(child);
	    		}
	    	}
	    }
	    
	    /*
	     * Universal iterator method
	     */
	    public boolean hasNext() {
	        return deque.peek() != null;
	    }

	    /*
	     * Universal iterator method
	     */
	    public E next() {
	    	current = deque.pollFirst();
	    	
	    	if (current != null) {
	    		enqueue(current);
	    		return current.get();
	    	}else {
	    		return null;
	    	}
	    }
	}
}