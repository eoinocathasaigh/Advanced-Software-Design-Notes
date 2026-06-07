package ie.atu.sw;

/* 
 * MessageObserver and MessageRequest objects are encapsulated in the 
 * Command object. It is the function of the receiver to know what to
 * do with a request containing a MessageObserver. In this case, such
 * requests result in the MessageObserver been added to the receivers
 * list of observers and will result in the MessageObserver being 
 * notified when a change occurs. Note: all implementations of this 
 * interface are serializable.
 */

//Class allows us to remotely plant an observer with the chat server
import java.io.*;
public interface MessageObserver extends Serializable{
	public String getName();
	public String getHost();
	public int getPort();
}