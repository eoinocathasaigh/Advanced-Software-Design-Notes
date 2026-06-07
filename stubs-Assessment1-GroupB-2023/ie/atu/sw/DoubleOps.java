package ie.atu.sw;

public class DoubleOps {
	Absolute abs = new Absolute();
	AbsoluteReverser arev = null;
	AbsoluteLogBase alb = null;
	AbsoluteLogBaseBitFlipper albf = null;

	public double getAbsoluteValue(double number) {
		return abs.absoluteIf(number);
	}
	
	public double getAbsoluteLogBaseValue(double number, Activity activity) {
		alb = new AbsoluteLogBase(activity.level());
		return alb.absoluteIf(number);
	}
	
	public double getAbsoluteLogBaseFlipperValue(double number, Activity activity) {
		alb = new AbsoluteLogBaseBitFlipper(activity.level());
		return alb.absoluteIf(number);
	}
	
	public double getAbsoluteReverser(double number) {
		arev = new AbsoluteReverser();
		return alb.absoluteIf(number);
	}
}