package ie.atu.sw.bridge;

public class Circle extends Shape{
	
	public Circle(Color color){
		super(color);
	}
	
	public void draw() {
		System.out.println("Drawing a Circle in " + color.applyColor() + " color.");
	}
}