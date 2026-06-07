package ie.atu.sw;

/*
 * Switch from one log base to another using the formula:
 *    log_b(x) = log_d(x) / log_d(b)
 */

import static java.lang.Math.log10;;

public class LogBase {
	double base;
	
	public LogBase(double base) {
		this.base = log10(base);
	}
	
	public double log(double number) {
		return log10(number) / base;
	}
}