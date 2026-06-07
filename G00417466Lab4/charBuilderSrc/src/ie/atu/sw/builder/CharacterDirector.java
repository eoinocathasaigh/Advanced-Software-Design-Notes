package ie.atu.sw.builder;

import java.util.ServiceLoader;
import ie.atu.character.*;
import ie.atu.sw.hamming.*;

//Initially adding in the methods will throw us an error as we inherit from fuzzy & normalised measurable 
//Both of them implement compare, just in different ways
public class CharacterDirector implements FuzzyMeasurable, NormalizedMeasurable {
	// We now need to create the BUILDER PATTERN
	// BUILDER PATTERN - Deals with multi step object creation - i.e. cant be done
	// with a factory which is a single step

	private Measurable measurable;
	// Instance variable for our character array builder
	private CharArrayBuilder builder = new CharArrayBuilder();

	// Methods from our character array builder
	public void append(char c) throws Exception {
		builder.append(c);
	}

	public CharSequence getCharSequence() { 
		// The product is a CharSequence
		return new String(builder.getSequence()).trim().intern();
	}

	// Loads the service provider interface
	public CharacterDirector() {
		loadSPI();
	}

	// Second constructor with dependency injection
	// We pass an interface implementation to a constructor and set it as an
	// instance/class variable
	public CharacterDirector(Measurable m) { // Dependency injection
		this.measurable = m;
	}

	private void loadSPI() { // Dependency injection
		// Basically says go through module path/descriptors & look for the
		// implementations of Measurable
		// Then return them in a list
		// We don't even mention concrete types here, we just want measurable - thats
		// polymorphism
		ServiceLoader<Measurable> services = ServiceLoader.load(Measurable.class);
		Measurable m = services.iterator().next();
		if (m != null)
			this.measurable = m;

		for (Measurable me : services) {
			System.out.println(me.getClass().getName());
		}
	}

	@Override
	public float getDistance(CharSequence s, CharSequence t) throws Exception {
		return measurable.getDistance(s, t); // Delegate
	}

	// This is one way of implementing the inherited method - can switch out
	// What they do is just refer to the super type
	// The point of this is that it's an ambiguity and we need to resolve it for the
	// project to compile
	@Override
	public float compare(CharSequence s, CharSequence t) throws Exception {
		return FuzzyMeasurable.super.compare(s, t);
		// return NormalizedMeasurable.super.compare(s, t);
	}

	// Main method for testing
	public static void main(String[] args) {
		new CharacterDirector();
	}
}
