package ie.atu.sw;

public enum Info {
	READY 			(100, "Ready for use"),
	ON_HOLD 		(200, "Temporarily Paused"),
	SUSPENDED 		(300, "Suspended for an undetermined period"),
	DEPRECATED 		(400, "Obsolete, but possibly in use"),
	REMOVED 		(666, "No longer supported");

	private int code;
	private String msg;
	
	Info(int cde, String msg) {
		this.code = cde;
		this.msg = msg;
	}

	public int code() {
		return code;
	}

	public String msg() {
		return msg;
	}
}