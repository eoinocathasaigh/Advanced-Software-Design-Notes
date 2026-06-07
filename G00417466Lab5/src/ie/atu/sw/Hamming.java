package ie.atu.sw;

/*
 * Hamming plays the role of a concrete state object in this lab. When the context
 * (StoredSequenceContext) changes state, it will switch the instance of the state 
 * interface (SequenceComparator) that it composed with.
 * 
 * The "final" modifier can be considered as a very strong form of sealing, 
 * where extension is prohibited completely. It is logically equal to declaring
 * a sealed class with a permits clause that specifies nothing (not valid syntax), 
 * e.g.
 * 
 *    public sealed class Hamming extends SequenceComparator permits
 *    
 * The class Hamming is the end of the line for this branch of the inheritance tree. 
 * The Hamming algorithm compares sequences by comparing the i-th character in each. 
 * While it can handle substitutions okay, a single insertion or deletion of a character
 * will throw the edit distance out completely. This algorithm has a space and time 
 * complexity of O(n).
 */

//Final Keyword means that Hamming cannot be sub classed
public final class Hamming extends SequenceComparator {
	public int getScore(CharSequence s, CharSequence t) {
		if (s.length() != t.length()) return -1; //Similar length strings only
		int counter = 0;
		
		for (int i = 0; i < s.length(); ++i){
			if (s.charAt(i) != t.charAt(i)) counter++;
		}
		return  counter;
	}
}