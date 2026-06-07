package ie.atu.sw.adapter;

public class NotificationSystem {
	private final MessageSender sender;

	public NotificationSystem(MessageSender sender) {
		this.sender = sender;
	}

	public void notifyUser(String message) {
		sender.send(message);
	}
}