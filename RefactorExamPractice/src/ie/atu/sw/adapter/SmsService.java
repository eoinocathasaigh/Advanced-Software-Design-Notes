package ie.atu.sw.adapter;

public class SmsService {
	public void sendText(String phoneNumber, String text) {
		System.out.println("Sending SMS to " + phoneNumber + ": " + text);
	}
}