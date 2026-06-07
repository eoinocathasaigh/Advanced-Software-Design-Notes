package ie.atu.sw;

import java.time.DayOfWeek;

public class Retainer { //Ideally should only be one Retainer in the system
	//There is a high likelihood that of more objects like these being retained in the future...
	Stringifier strg = new Stringifier();
	MaskerClipper mskc = new MaskerClipper();
	ClipperReverser crev = new ClipperReverser();
	Constrainer cnstr = new Constrainer();
	
	
	//This method is too long and doing way too much...
	public Object retain(Info info, String val) {
		switch (info) {
			case READY, ON_HOLD -> {
				if (strg != null) {
					return strg.doXOR(new StringBuffer(val));
				}else if (crev != null) {
					return crev.clip(val);
				}else if (cnstr != null) {
					return cnstr.constrain(val);
				}
			}
		
			case REMOVED, SUSPENDED  -> {
				//Ideally only should execute one of these that is not null
				if (strg != null) {
					strg.day = DayOfWeek.MONDAY;
					return strg.process(val);
				}else if (crev != null) {
					crev.remove = 'b';
					return crev.clip(val);
				}else if (cnstr != null) {
					cnstr.constrain = "[a-zA-Z]";
					return cnstr.constrain(val);
				}
			}
			case DEPRECATED -> {
				crev.clip(val);
			}
		default -> throw new IllegalArgumentException("Unexpected value: " + info);
		}
		
		return null;
	}
}