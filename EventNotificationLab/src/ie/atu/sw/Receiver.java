package ie.atu.sw;

/* 
 * This interface defines the behaviour for a receiver of a command object.
 * Note that the receiver supports both MessageObserver and MessageRequest
 * types.
 */

//Interface for setting up messageObserver things while also being command objects
public interface Receiver {
	public void add(MessageObserver observer);
	public void remove(MessageObserver observer);
	public void update(MessageRequest request);
}