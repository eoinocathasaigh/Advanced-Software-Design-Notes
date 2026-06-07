package ie.atu.sw;

/*
 * Clips a string and reverses the bits of an integer 
 * above a threshold
 */
public class ClipperReverser {
	char remove = 'a';
	int THRESHOLD = 42; 
	
	public CharSequence clip(CharSequence s) {
		var builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != remove) builder.append(s.charAt(i));
		}
		return builder.toString();
	}
	
	public int reverseIf(int num) {
		return num > THRESHOLD ? Integer.reverse(num) : num;
	}
}