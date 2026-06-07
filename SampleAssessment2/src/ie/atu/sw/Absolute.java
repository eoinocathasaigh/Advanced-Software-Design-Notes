package ie.atu.sw;

import static java.lang.Math.*;
public class Absolute {
	final double threshold = 42.00d; //The meaning of life
	
	//A problem we will see across these files is the misuse of these methods
	//They all have the same parameters & return type - means turn it into a interface
	//They have different method names but similar operations
	public double absoluteIf(double number) {
		return number >= threshold ? abs(number) : number;
	}
}