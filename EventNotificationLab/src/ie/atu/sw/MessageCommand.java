package ie.atu.sw;

/* 
 * The command interface encapsulates invocations from the message client
 * to the receiver. In this case, a request to the receiver (who does
 * the actual work) can be either of the following:
 * 	1)A request to be added as an observer.
 *  2)A request to propagate a message to other clients.
 * The point is that both request types are encapsulated in the 
 * command object. An invoker calls execute() and the receiver
 * does whatever execute() tells it to do - in this case add() or
 * update(). Note: all implementations of this interface are
 * serializable.
 */

//We extend serializable since we're sending things over the network
import java.io.*;
public interface MessageCommand extends Serializable{
	//2 methods
	public void setReceiver(Receiver r);
	public void execute();
}
