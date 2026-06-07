package ie.atu.sw.bridge;

public class Client {

	public static void main(String[] args) {
		Shape s = new Circle(new RedColor());
		s.draw();
	}

}