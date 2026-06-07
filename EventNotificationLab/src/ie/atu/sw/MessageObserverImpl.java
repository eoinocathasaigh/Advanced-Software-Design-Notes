package ie.atu.sw;

/* 
 * MessageObserverImpl is both a concrete command object and a MessageObserver.
 * When execute() is called by the invoker, the add() method of the receiver
 * is invoked. 
 */

/*This class will retain the receiver (who it got the message from) & other stuff for the observer
 * Receiver will at some point invoke the host commands*/
public class MessageObserverImpl implements MessageObserver, MessageCommand{	
	private static final long serialVersionUID = 777L;	
	private transient Receiver receiver;
	private String name;
	private String host;
	private int port;
	
	//This info is planted on the observer and allows us to get a response
	public MessageObserverImpl(String name, String host, int port) {
		this.name = name;
		this.host = host;
		this.port = port;
	}

	public void setReceiver(Receiver r){
		this.receiver = r;
	}
	
	//This basically asks the server to add this client as a listener "include me"
	public void execute(){
		receiver.add(this);
	}
	
	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getName() {
		return name;
	}
}