package ie.atu.sw;

/*
 * SmithWaterman plays the role of a concrete state object in this lab. When the context
 * (StoredSequenceContext) changes state, it will switch the instance of the state 
 * interface (SequenceComparator) that it composed with.

 * A permitted subtype must declare how it continues the sealing initiated by its 
 * super-type. The class SmithWaterman declares that it is non-sealed, allowing its 
 * part of the inheritance hierarchy reverts to be re-opened for extension.
 *
 * The SmithWaterman distance algorithm computes the edit distance between two strings 
 * and accounts for substitutions, insertions and deletions and is able (using a trace-back
 * step that is not implemented here) to return the optimal matching subsequence. The algorithm 
 * has a space and time complexity of O(n^2).
 */

//Declared as non-sealed: opened up this whole branch - branch of the whole inheritance tree
//Anyone can inherit this class

//SEALS BASICALLY ALLOW COMPILER TO ENUMERATE THE POSSIBLE TYPES A THING MIGHT HAVE

//What his the point of a state pattern?
//To dynamically change behaviour when internal state changes


public non-sealed class SmithWaterman extends SequenceComparator{
	private static final int MATCH = 2, MISMATCH = -1, GAP = -1;

	public int getScore(CharSequence s, CharSequence t) {
		super.store(new int[s.length() + 1][t.length() + 1]);
		
		int max  = 0;
		for (int i = 1; i < super.getMatrix().length; i++){
			for (int j = 1; j < super.getMatrix()[i].length; j++){
				super.getMatrix()[i][j] = Math.max(super.getMatrix()[i - 1][j] + GAP, Math.max(super.getMatrix()[i][j - 1] + GAP, super.getMatrix()[i - 1][j - 1] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? MATCH : MISMATCH)));
				if (super.getMatrix()[i][j] > max) max = super.getMatrix()[i][j];
			}
		}
		return max;
	}
}