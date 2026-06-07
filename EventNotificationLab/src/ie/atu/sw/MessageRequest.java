package ie.atu.sw;

/* MessageRequest, like MessageObserver, is encapsulated in the 
 * command object (MessageCommand). When the invoker calls 
 * execute() on the command object, the receiver updates all
 * observers with the new message. Note: all implementations of this 
 * interface are serializable.
 */

//Simple interface encapsulating message requests
import java.io.*;
public interface MessageRequest extends Serializable{
	public String getName();
	public void setMessage(String message);
	//Person who sent the message
	public String getMessage();	
}
