package ie.atu.sw;

/*
 * Levenshtein plays the role of a concrete state object in this lab. When the context
 * (StoredSequenceContext) changes state, it will switch the instance of the state 
 * interface (SequenceComparator) that it composed with.

 * A permitted subtype must declare how it continues the sealing initiated by its 
 * super-type. The class Levenshtein itself is sealed and permits only one branch
 * of inheritance.
 * The Levenshtein distance algorithm computes the edit distance between two strings 
 * and accounts for substitutions, insertions and deletions. The algorithm has a space 
 * and time complexity of O(n^2).
 */

//Class is sealed similarly to SequenceComparator 
public sealed class Levenshtein extends SequenceComparator permits DamerauLevenshtein{
	
	protected void initialise(CharSequence s, CharSequence t) {
        int[][] matrix = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) matrix[i][0] = i;
        for (int j = 0; j <= t.length(); j++) matrix[0][j] = j;
    	
    	super.store(matrix);
	}
	
    public int getScore(CharSequence s, CharSequence t) {
    	initialise(s, t);
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
            	super.getMatrix()[i][j] = Math.min(super.getMatrix()[i - 1][j] + 1, 
                				 		  Math.min(super.getMatrix()[i][j - 1] + 1, 
                						   super.getMatrix()[i - 1][j - 1] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1)));
            }
    
        }
        return super.getMatrix()[s.length()][t.length()];
    }
}