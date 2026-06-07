package ie.atu.sw.adapter;

public class SmsAdapter implements MessageSender {

	private SmsService smsService;
	private String phoneNumber;
	
	public SmsAdapter(SmsService smsService, String phoneNumber) {
		this.smsService = smsService;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public void send(String message) {
		smsService.sendText(phoneNumber, message);
	}

}