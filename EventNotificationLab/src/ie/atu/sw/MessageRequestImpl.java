package ie.atu.sw;

/* 
 * MessageRequestImpl is both a concrete command object and a MessageCommand.
 * Like all command objects, it keeps a reference to the receiver. In this case
 * it is set by the invoker on the server side (perhaps there is a better way to
 * do this...I'll leave that to you in the lab!). Note that the instance variable 
 * for the receiver is transient. This prevents the Receiver instance from being
 * serialized with the rest of the class. Also note the class field 
 * serialVersionUID. If you do not explicitly set this, the compiler will 
 * generate one for you. As the serialVersionUID is used as a version control
 * variable in serialization, letting the compiler generate it can lead to problems 
 * in client/server environments.
 * 
 * When the invoker calls execute() on this command object, execute() in turn calls 
 * update() on the receiver. Through the power of polymorphism, this object can 
 * behave as both a command object and a message request. 
 */

//Command object where we're also implementing a message request
//This file will be used to update the specific clients - its execute method updates as opposed to adding
//We hold onto the message we're receiving and who its from
public class MessageRequestImpl implements MessageRequest, MessageCommand{
	private transient Receiver receiver;
	private static final long serialVersionUID = 1L;
	private String message;
	private String name;
	
	public MessageRequestImpl(String name, String message){
		this.name = name;
		this.message = message;
	}
	
	public void setReceiver(Receiver r){
		this.receiver = r;
	}
	
	public void execute(){
		receiver.update(this);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}