package ie.atu.sw;

/* 
 * The class SequenceComparator plays the role of the State abstraction and defines
 * abstract methods, handle() in the state pattern, that concrete strategies must
 * implement.
 * 
 * SequenceComparator is a sealed type and is widely accessible but not widely extensible.
 * The class can only be can be extended only by those classes declared permitted to do so.
 */

//Class is marked as sealed - we only allow Hamming, Levenshtein & SmithWaterman to inherit from it, anyone else would fail to compile
public abstract sealed class SequenceComparator permits Hamming, Levenshtein, SmithWaterman{
	//Variable for our state - 2d array of ints aka a dynamic programming matrix (DPMatrix)
	private int[][] dpMatrix;
	
	protected final void store(int[][] matrix) {
		this.dpMatrix = matrix;
	}

	protected int[][] getMatrix() {
		return dpMatrix;
	}
	
	//This is our single abstract method - since this is an abstract class
	public abstract int getScore(CharSequence s, CharSequence t);
}