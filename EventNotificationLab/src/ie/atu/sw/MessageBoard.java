package ie.atu.sw;

import java.io.*;
import java.net.*;
import java.util.*;

// As a receiver, MessageBoard knows how to perform the action needed to carry out a request. 

//This is an observer
//We maintain a list of observers/message observers - array list
//Since this class manages a lot of things its a singleton
//If we need to add a new client we simply add it to the array list of observers
public class MessageBoard implements Receiver{
	private static MessageBoard mb = new MessageBoard(); //A singleton instance of the class
	private List<MessageObserver> observers = new ArrayList<>(); //List of observers

	private MessageBoard(){ //The Highlander Principle - "There can be only one". 
		//BTW - this is only a known principle among my students...
	}
	
	public static MessageBoard getInstance(){
		return mb;
	}
	
	//These are registering commands - handling things like updating, adding and removing from the list
	//Dispatch the new MessageRequest to each observer in our list
	public void update(MessageRequest request){
		for (MessageObserver observer: observers){
			dispatch(observer, request);
		}
	}
	
	//Add a new observer to our list
	public void add(MessageObserver observer){
		observers.add(observer);
	}

	public void remove(MessageObserver observer) {
		observers.removeIf(n -> n.getHost().equals(observer.getHost()));
	}

	//open a socket back to a client and send it the new MessageRequest 	
	//We dispatch/send message over the network by getting the port and host for a specific observer and then sending the request
	private void dispatch(MessageObserver observer, MessageRequest request){
		try(var out = new ObjectOutputStream(
			new Socket(observer.getHost(), observer.getPort()).getOutputStream())){
			out.writeObject(request);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}