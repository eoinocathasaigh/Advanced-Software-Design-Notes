package ie.atu.sw;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*
 * Performs reverse and XOR operations on strings
 */
public class Stringifier {
	char[] key = {'F','E','L','I','X',' ','D','I','E','B','U','S','!'};
	DayOfWeek day = DayOfWeek.FRIDAY;
	
	public String process(String s) {
		if (LocalDate.now().getDayOfWeek() == day) return s;
		
		return new StringBuilder(s).reverse().toString();
	}
	
	public String doXOR(StringBuffer buf) {
		if (buf.length() > key.length) return new String(buf);
		
		var sb = new StringBuilder();
		for (int i = 0; i < buf.length(); i++) {
			sb.append(buf.charAt(i) ^ key[i]);
		}
		return sb.toString();
		
	}
}