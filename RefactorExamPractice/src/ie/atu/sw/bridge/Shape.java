package ie.atu.sw.bridge;

public abstract class Shape {
	protected Color color;
	
	protected Shape(Color color) { //dependency injection
		this.color = color;
	}
	
	abstract void draw();
}