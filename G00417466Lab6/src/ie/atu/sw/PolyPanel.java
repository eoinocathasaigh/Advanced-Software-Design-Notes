package ie.atu.sw;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
//Need to import this one specifically to work with javafx
import javafx.scene.shape.Polygon;

//This class extends hbox to help us draw what we want
public class PolyPanel extends HBox {

	//Favouring composition - this class "has-a" polygon
	private Polygon p = new Polygon();
	
	public PolyPanel() {
		super();
		//Initially drawing it when the window boots up
		draw();
		//We get our models children
		super.getChildren().add(p);
		//We then make a lambda expression for the even of clicking the mouse
		this.setOnMouseClicked(e -> draw());
	}

	// Method to draw the shape we want
	public void draw() {
		
		//This sets up the colours for the polygon - random each time
		p.setStroke(Color.color(Math.random(), Math.random(),Math.random()));
		p.setFill(Color.color(Math.random(), Math.random(),Math.random()));
		for (int i = 0; i < 6; i++) {
			p.getPoints().addAll(new Double[] { 
					(100 + 50 * Math.cos(i * 2 * Math.PI / 6)),
					(100 + 50 * Math.sin(i * 2 * Math.PI / 6)) });
		}
	}
	
	//WE THEN NEED TO ADD THIS BACK IN OUR APP WINDOW
}
