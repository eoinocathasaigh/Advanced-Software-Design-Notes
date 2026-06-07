package ie.atu.sw;

//OBJECT ADAPTER
//This way will use has-a as opposed to is-a inheritance 

//This does the same stuff - reuse through composition as opposed to inheritanc
public class ComStoredSequenceListAdapter implements SequenceListStore{
	//A lot more flexible than previous iteration
	//We could change out this line for our new implementation - can be done at compile time
	private StoredSequenceContext ssc;
	
	public ComStoredSequenceListAdapter(CharSequence s) {
		ssc = new StoredSequenceContext(s);
	}

	@Override
	public void open(CharSequence fileName) throws Exception {
		ssc.open(fileName);
	}

	@Override
	public void store(CharSequence[] list) throws Exception {
		for(CharSequence cs: list) {
			ssc.store(cs);
		}
	}

	@Override
	public void close() throws Exception {
		ssc.close();
	}

}
