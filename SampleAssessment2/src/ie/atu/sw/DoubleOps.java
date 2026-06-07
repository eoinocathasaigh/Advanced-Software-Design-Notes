package ie.atu.sw;

//Could make this a singleton too - it manages operations 
public class DoubleOps {
	//Problem here - Tight Coupling
	//We're creating/instantiating concrete classes - bad idea
	Absolute abs = new Absolute();
	AbsoluteReverser arev = null;
	AbsoluteLogBase alb = null;
	AbsoluteLogBaseBitFlipper albf = null;

	public double getAbsoluteValue(double number) {
		return abs.absoluteIf(number);
	}
	
	//Problem with these methods - we're constantly creating new objects with every method call
	//All these methods also just do similar things but use different methods/call different methods
	//Could implement a strategy pattern or a factory here - cut down on the code we have
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
	
	/*SOLUTION
	 * Step 1: Extract Interface
	 * - All the absolute methods have the same type of "absoluteIf() method
	 * - So we need to extract an interface and apply it to all of them
	 *interface DoubleOperation {
    		double process(double value);
	  }*/
	//We then need to refactor the different log classes to use/implement the interface as opposed to extending each other
	
	
}