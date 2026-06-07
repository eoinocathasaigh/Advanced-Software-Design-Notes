package ie.atu.sw;

/* MessageClient is the client of our remote message service. The Naming.lookup() call
 * is a request to a remote registry for an object with a human-readable name. The object 
 * returned is really an instance of a proxy stub, but the client thinks it is dealing with 
 * the real remote object. The lookup() method returns a type of java.lang.Object which we need
 * to cast to the interface type. The statement:
 * 
 *			Message message = ms.getMessage();
 * 		
 * is the actual remote method invocation. Notice how there no special coding required
 * to deal with the remote invocation. This is an example of Local/Remote Transparency.
 *
 *
 * Note also that there is no reference to any server-side object type except for the remote
 * interface. The client is loosely-coupled with the remote object. If we don't like our
 * implementation of the remote object, we can substitute it with a different class that
 * implements MessageService without having to recompile the client.
 */
import java.rmi.Naming;
public class MessageClient {
	public static void main(String[] args) throws Exception{
		
		//Ask the registry running on 10.2.2.65 and listening in port 1099 for the instannce of
		//the MessageService object that is bound to the RMI registry with the name ATUMessageService.
		MessageService ms = (MessageService) Naming.lookup("rmi://127.0.0.1:1099/ATUMessageService");
		
		//Make the remote method invocation. This results in the Message object being transferred
		//to us over the network in serialised form. 
		//Now that we've implemented remote message this is now a remote method invocation - original invocation
		RemoteMessage message = ms.getMessage();
		
		//Print out the message from the message object.
		//This also becomes a remote method invocation
		System.out.println(message.message());
		
		System.out.println("Message ->" + message);
		//Printing out the message service
		//Declaring it does a look up on the registry - contacting the rmi at a specific machine/address - at the specific port we started previously
		//Ask it to return anything human readable under the name "ATUMessageService
		//Previously we added an instance of messageService with impl in it - remote object (downcasting)
		//The declaration statement returns a fully initialised proxy (pretends its the real subject)
		//Dynamic remote proxy meaning its created on the fly, gives us access to the resource
		//The hash number we see printed here identifies the particular skeleton of the particular remote object - remote object here is MessageServiceImpl
		System.out.println(ms);
		System.out.println(ms instanceof MessageService);
		System.out.println(ms.getClass().getName());
		
		//After we change it to a remote object we will get the same sorts of information returned like ip etc the difference is that they're pointing to different things
		//Wasnt hard to implement either - we just changed the message server
		//- Now whenever they call the server theyre returned a proxy for remote server
	}
}
