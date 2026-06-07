package ie.atu.sw;
import java.rmi.*;
import java.rmi.server.*;

//WHAT IS THIS CLASS DOING
//Helps us return a pass-by-reference
//Extends UnicastRemoteObject so it is a remote object itself
public class RemoteMessageImpl extends UnicastRemoteObject implements RemoteMessage, Unreferenced {
	private static final long serialVersionUID = 1L;
	//Uses a normal message - but puts a wrapper of sorts around it
	private Message message;
	private static int refCount = 0;
	private int objNum = 0;

	public RemoteMessageImpl(String message) throws RemoteException {
		this.message = new Message(message);
		objNum = refCount;
		System.out.println("[RemoteMessage] #References: " + refCount + ". Object#" + objNum);
		refCount++;
	}

	//Delegation
	public String message() throws RemoteException {
		return message.message();
	}

	public int getReferenceCount() throws RemoteException {
		return refCount;
	}

	public int getObjectNumber() throws RemoteException {
		return objNum;
	}

	//Bog standard method called when a method goes out of scope but before it gets garbage collected
	public void finalize() throws Throwable {
		System.out.println("[RemoteMessage Finalize called. About to be GCd.]");
	}

	public void unreferenced() {
		System.out.println("[RemoteMessage Unreferenced, Object No: " + objNum + "]");
	}
}