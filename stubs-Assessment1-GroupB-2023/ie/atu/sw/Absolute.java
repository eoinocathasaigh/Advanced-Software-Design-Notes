package ie.atu.sw;

import static java.lang.Math.*;
public class Absolute {
	final double threshold = 42.00d; //The meaning of life
	
	public double absoluteIf(double number) {
		return number >= threshold ? abs(number) : number;
	}
}