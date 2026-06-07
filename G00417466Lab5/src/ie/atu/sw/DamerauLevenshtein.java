package ie.atu.sw;

/*
 * DamerauLevenshtein plays the role of a concrete state object in this lab. When the context
 * (StoredSequenceContext) changes state, it will switch the instance of the state 
 * interface (SequenceComparator) that it composed with.
 * 
 * The "final" modifier can be considered as a very strong form of sealing, 
 * where extension is prohibited completely. It is logically equal to declaring
 * a sealed class with a permits clause that specifies nothing (not valid syntax), e.g.
 * 
 *    public sealed class DamerauLevenshtein extends Levenshtein permits
 *    
 * The class DamerauLevenshtein is the end of the line for this branch of the 
 * inheritance tree. The DamerauLevenshtein algorithm extends Levenshtein distance
 * by including transposition along with substitutions, insertions and deletions. This
 * algorithm has a space and time complexity of O(n^2).
 */

//Similar to levenshtein but this time it allows transposition as well as the previous substitutions
public final class DamerauLevenshtein extends Levenshtein{
	
    public int getScore(CharSequence s, CharSequence t) {
        super.initialise(s, t);

        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
            	super.getMatrix()[i][j] = Math.min(super.getMatrix()[i - 1][j] + 1, 
                		         		  Math.min(super.getMatrix()[i][j - 1] + 1, 
                		        		  super.getMatrix()[i - 1][j - 1] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1)));
            
                if ((i > 1) && (j > 1) && (s.charAt(i-1) == t.charAt(j-2)) && (s.charAt(i-2) == t.charAt(j-1))){
                	super.getMatrix()[i][j] = Math.min(super.getMatrix()[i][j], super.getMatrix()[i-2][j-2] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1));
                }
            }
    
        }
        return super.getMatrix()[s.length()][t.length()];
    }
}