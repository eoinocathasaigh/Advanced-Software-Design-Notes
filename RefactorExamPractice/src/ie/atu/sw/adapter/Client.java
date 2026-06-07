package ie.atu.sw.adapter;

public class Client {
	public static void main(String[] args) {
		SmsService legacySms = new SmsService();
		MessageSender smsAdapter = new SmsAdapter(legacySms, "+353 083 172 1354");
		NotificationSystem ns = new NotificationSystem(smsAdapter);
		ns.notifyUser("your code has been verified");
	}
}