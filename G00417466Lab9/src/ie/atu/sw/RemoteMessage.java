package ie.atu.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

//To make this a remote interface we extend remote first and then add an exception to the method
public interface RemoteMessage extends Remote{
	
	//Implicitly public but we make it so
	public String message() throws RemoteException;

}