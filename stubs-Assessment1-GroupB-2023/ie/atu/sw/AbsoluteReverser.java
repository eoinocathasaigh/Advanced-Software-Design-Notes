package ie.atu.sw;

public class AbsoluteReverser extends Absolute{
	
	public double reverse(double number) {
		double abs =  super.absoluteIf(number);
		long temp = Double.doubleToLongBits(abs);
		return Long.reverse(temp);
	}
}