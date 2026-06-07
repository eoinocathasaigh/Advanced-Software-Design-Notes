package ie.atu.sw;

public class AbsoluteLogBaseBitFlipper extends AbsoluteLogBase{

	public AbsoluteLogBaseBitFlipper(double base) {
		super(base);
	}

	public double flip(double value) {
		value = super.absoluteIf(value);
		
		//Convert to a 64 bit long, flip the bits and return a 64 bit double
		long temp = Double.doubleToLongBits(value);
		return ~temp; 
	}
}