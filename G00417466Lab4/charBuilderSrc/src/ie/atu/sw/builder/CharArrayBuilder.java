package ie.atu.sw.builder;
import java.io.IOException;

//This class is meant to help simulate the builder pattern - multi step object creation
//In the original pattern a director directs the builder on what to build
//Builder knows how to build the individual bits 
//The director knows how to do the whole thing at a high level but doesnt know how to do the individual bits

//Appendable relates to an interface that can be appended - comes with 3 methods for appending that need to be implemented properly
public class CharArrayBuilder implements Appendable {
	private char[] sequence;
	private int index;

	public CharArrayBuilder() {
		this(8);
	}

	public CharArrayBuilder(int length) {
		this(new char[length]);
	}

	public CharArrayBuilder(char[] s) {
		this.sequence = s;
	}

	public char[] getSequence() {
		return sequence;
	}

	//EXPANDING IN AMORTIZED CONSTANT TIME LIKE AN ARRAYLIST - we just copy the values into a new array of a larger size
	private void expand() {
		char[] t = new char[(sequence.length * 3) / 2]; // Amortized expansion
		for (int i = 0; i < sequence.length; i++) {
			t[i] = sequence[i];
		}
		sequence = t;
	}

	//Appending a single character onto the word
	@Override
	public Appendable append(char c) throws IOException {
		if (index >= sequence.length - 1)
			expand();
		sequence[index] = c;
		index++;
		return this;
	}

	//Appending a character sequence
	@Override
	public Appendable append(CharSequence csq) throws IOException {
		return append(csq, 0, csq.length());
	}

	//Appending but repeatedly calling the first append method
	@Override
	public Appendable append(CharSequence csq, int start, int end) throws IOException {
		for (int i = start; i < end; i++) {
			append(csq.charAt(i));
		}
		return this;
	}
}