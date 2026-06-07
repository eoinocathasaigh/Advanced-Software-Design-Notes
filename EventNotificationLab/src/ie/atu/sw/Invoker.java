package ie.atu.sw;

/*
 * The invoker holds a command object and calls the execute method
 */
import java.io.*;
import java.net.*;

//Class is responsible for running the command
//Its a runnable - runs in it's own thread
public class Invoker implements Runnable{ 
	private Socket s = null;
	
	//We initialise the socket and handle the rest
	public Invoker(Socket sock){
		this.s = sock;
	}
	
	//Good thing about this method is that it never has to change - we have a bunch of potential
	//We dont have loads of if statements we just get the specific instance and run it - command object
	//We could be doing hundreds of things
	public void run(){
		//Deserialize the socket input stream into a MessageCommand
		try(var in = new ObjectInputStream(s.getInputStream())){
			/* Assign a receiver to the command object and call execute()
			 * By encapsulating the request in a command object, we
			 * dispense with the need to have IF/instanceof statements here.
			 * The command approach encapsulates the change that an 
			 * invoker would otherwise have to deal with. 
			 */
			if (in.readObject() instanceof MessageCommand cmd) {
				cmd.setReceiver(MessageBoard.getInstance()); //Set the receiver. This should be done by the client, but not in client-server mode
				//A way to delay this would be to add it to a message queue - put request in a queue so its not immediate
				cmd.execute(); //Execute the command method. Note that the invoker does not know what this does...
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}