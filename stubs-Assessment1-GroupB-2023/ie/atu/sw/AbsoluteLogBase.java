package ie.atu.sw;

public class AbsoluteLogBase extends Absolute{
	
	LogBase logBase;
	
	public AbsoluteLogBase(double base) {
		logBase = new LogBase(base);
	}

	@Override
	public double absoluteIf(double number) {
		double abs =  super.absoluteIf(number);
		return logBase.log(abs);
	}
}
