package ie.atu.sw;

/* MessageServiceImpl is an example of a Remote Object. As this class implements the remote
 * interface MessageService, it must also implement the remote method:
 * 
 *			public Message getMessage() throws RemoteException
 * 
 * MessageServiceImpl also is a subclass of UnicastRemoteObject. This superclass provides the 
 * remote object with all the functionality it needs to communicate with the server-side 
 * skeleton - the object that is responsible for unmarshalling client requests on the server 
 * and marshalling responses. Note that the proxy stub used by the client to communicate with 
 * the server is dynamically generated from this class. Client invocations are routed through 
 * this proxy over the network to the skeleton (another dynamic proxy) and then on to the remote 
 * object.
 * 
 * The remote object is the ultimate target for a remote method invocation. Before any remote 
 * client can invoke any of its methods, the remote object must first be instantiated and bound 
 * to a naming registry with a human-readable name. This binding is done in the class MessageServer. 
 */
import java.rmi.*;
import java.rmi.server.*;
public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {
	private static final long serialVersionUID = 1L;
	private RemoteMessage message;
	
	public MessageServiceImpl(RemoteMessage m) throws RemoteException{
		this.message = m;
	}
	
	public RemoteMessage getMessage() throws RemoteException {
		return message;
	}
}