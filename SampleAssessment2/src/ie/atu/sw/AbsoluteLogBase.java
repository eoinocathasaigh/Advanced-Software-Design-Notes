package ie.atu.sw;

public class AbsoluteLogBase extends Absolute{
	
	//This class "has-a" logBase so we know this is composition
	LogBase logBase;
	
	public AbsoluteLogBase(double base) {
		//Composition over inheritance violation - we aren't inheriting anything
		//Composition here is misused - we should used dependency injection here instead
		//It is better for us to inject operations as opposed to composing them
		logBase = new LogBase(base);
	}

	@Override
	public double absoluteIf(double number) {
		//This is inheritance misuse - all it does is extend the absolute if, only to use the super() method
		//Composition would be a better suit here than inheritance
		double abs =  super.absoluteIf(number);
		return logBase.log(abs);
	}
}
