package ie.atu.sw;

import java.io.*;
import java.net.*;
import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

import static java.lang.System.*;

//What this class does - acts as the client for the application
public class MessageClient extends Application{
	private int listenPort = 9998;
	private String clientIP;
	private String remoteHost;
	private int remotePort;
	private ServerSocket ss = null;
	private TextArea txtConversation = null;

	//These are good examples of template methods - dont call us we'll call you
	//When ready things will start and appear on our screen - when a connection is properly set up
	@Override
    public void start(Stage stage) throws Exception {
		//Build a tree of nodes to create the GUI
		stage.setTitle("Message Client");
		stage.setWidth(500);
		stage.setHeight(300);
		//Plant an observer on it for when we close it
		stage.setOnCloseRequest((e) -> System.exit(0)); //Kill the VM when window is closed
		
		//VBox is a Layout (a Concrete Strategy) and the Scene object is the Context.
		var box = new VBox();
		box.setPadding(new Insets(10));
	    box.setSpacing(8);
		
	    var scene = new Scene(box, 500, 300);
		stage.setScene(scene);
		
		//We then create a text area "chat" for the box
		txtConversation = new TextArea(); //The "chat" is displayed in a text area
		txtConversation.setEditable(false); //Editing disabled
		
		var txtMessage = new TextField(); //Text field for a message
		
		/* Calling setOnAction() tells FX to register the EventHandler 
		 * observer (the lambda) to be notified when btnSendis clicked. 
		 * The FX event dispatch manager calls actionPerformed() when
		 * this event occurs. In this case, handle(ActionEvent ae) opens 
		 * a socket to the chat server and sends a serialized MessageRequest 
		 * containing the new message. 
		 */
		
		//Lambda expression for what happens when we press "send message"
		var btnSend = new Button("Send Message");
		btnSend.setOnAction(e -> { //Plant an observer with the event dispatch mameger
			//We try making a new output stream by getting the remote host and port from the output stream
        	try (var out = new ObjectOutputStream(new Socket(remoteHost, remotePort).getOutputStream())){
        		//We then need to write out the object - needs to be "cerialisable" - we then get the specific user "who sent it" 
				out.writeObject(new MessageRequestImpl(System.getProperty("user.name"), txtMessage.getText()));
        	}catch(Exception ex){
        		ex.printStackTrace();
        	}
        	txtMessage.clear();
		});
		
		//Build the tree of nodes to form the GUI
		box.getChildren().add(txtConversation);
		box.getChildren().add(txtMessage);
		box.getChildren().add(btnSend);
		
		//Display the window
		stage.show();
		stage.centerOnScreen();
		
		//Initialise the observer
		List<String> params = getParameters().getRaw(); 
		this.clientIP = params.get(0); //Hard-coding ordinal is not good...
		this.remoteHost = params.get(1); 
		this.remotePort = Integer.parseInt(params.get(2));
		initConnections();
		out.println("[INFO] Client ready...");
	}

	//We set up the listeners using this method - just call the other ones
	public void initConnections() throws Exception {
		initListener();
		registerObserver();
	}
	
	//Start a socket on the client to listen for push notifications from the service 
	private void initListener() throws Exception {
		listenPort = getRandomPort();
		ss = new ServerSocket(listenPort);
		new ClientListener().start();
	}

	
	//Open a socket to the chat server and register as an observer
	//We basically just invoke the server and ask to be added to it's list of clients
	private void registerObserver() throws Exception {
		try(var out = new ObjectOutputStream(new Socket(remoteHost, remotePort).getOutputStream())) {
			out.writeObject(new MessageObserverImpl(System.getProperty("user.name"), clientIP, listenPort));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Update the text pane with incoming message
	//This is just when a message is displayed
	private void updateDisplay(MessageRequest request) {
		 var sb = new StringBuilder(); 
		 sb.append(txtConversation.getText());
		 sb.append("\n" + request.getName() + ">" + request.getMessage());
		 txtConversation.setText(sb.toString());
	}

	
	/*
	 * The client application needs to open a sock in order to listen for incoming
	 * message updates from the chat server. The client host name and port number
	 * and encapsulated in a MessageObserver instance that the constructor created
	 * and registers as an observer.
	 */
	//This is a simplistic method that will essentially hang and wait for an event/request
	class ClientListener extends Thread {
		public void run() {
			out.println("[INFO] Listener started");
			while (true) {				
				try(var oin = new ObjectInputStream(ss.accept().getInputStream())) {
					if (oin.readObject() instanceof MessageRequest request) {
						updateDisplay(request);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getRandomPort() {
		int max = 9998; int min = 9000;
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	//This acts as a static method for just starting the application
	public static void main(String[] args) {
		String[] params = {"127.0.0.1", "127.0.0.1", "9999"};
		Application.launch(params); //Can read in String[] args to a Stage
	}
	
	//We hope to use the observer pattern to create a simple messaging application using javafx
	//To actually get this file to work we need to download the javafx 
	//We have a command interface which defines the method "execute"
	
	/*HOW THIS WORKS
	 * Clients opened act as "observers" - plant observers with server running in the background
	 * When we send a message it basically goes to the server who has to iterate over its clients/observers and let them know they need to update
	 * */
}