package ie.atu.sw;

/*
 * StoredSequenceContext plays the role of the Context in the State Pattern
 * and is responsible for changing behaviour, i.e. the instance of SequenceComparator
 * when its state changes (implemented as local method parameters). 
 * 
 * This class also plays the role of the Adaptee in the Adapter Pattern. While the 
 * class arguably violates the SRP, it is responsible for the following:
 * 
 *   Comparing sequences against its own sequence s.
 *   Saving sequences to file. 
 */

//Helps us change things like state when change is detected in internal behaviour
import java.io.FileWriter;
public class StoredSequenceContext {
	private SequenceComparator asc = new Hamming();
	private CharSequence s;
	private FileWriter fw;
	
	public StoredSequenceContext(CharSequence s) {
		this.s = s;
	}
	
	//A lot of this is delegation - someone elses problem
	//All based on some internal state change
	//Allows us to dynamically change "asc" when state changes
	public int compare(CharSequence t, boolean transpositions, boolean gaps) {
		if (t.length() != s.length()) {
			if (transpositions) {
				asc = new DamerauLevenshtein();
			}else {
				if (gaps) {
					asc = new SmithWaterman();
				}else {
					asc = new Levenshtein();
				}
			}
		}
		
		System.out.println("Executing " + asc.getClass().getName());
		return asc.getScore(s, t);		
	}
	
	 public void open(CharSequence file) throws Exception{
         fw = new FileWriter((String) file);
	 }
	
	 public void close() throws Exception{
		 fw.close();
	 }
	 
	 public void store(CharSequence s) throws Exception{
		 fw.write(s + "\n");
	 }
}