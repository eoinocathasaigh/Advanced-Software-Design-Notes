package ie.atu.sw;

public class MaskerClipper {
	
	//Clips a string past a given length
	public String clip(Object obj, int max) {
		var s = obj.toString();
		return s.length() > max ? s.substring(0, max) : s; 
	}
	
	//Masks an integer using a bitwise AND
	int mask(int number, int mask) {
	    return number & mask;
	}
	
	//Quick divide by 2 using a bit shift
	int divideByTwo(int number) {
		return number >> 1;
	}
	
	//Quick multiply by 2 using a bit shift
	int multiplyByTwo(int number) {
		return number << 1;
	}
}