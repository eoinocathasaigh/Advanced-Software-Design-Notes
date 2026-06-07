package ie.atu.sw;

//THIS CLASS WILL BE OUR ADAPTER - NEED TO EXTEND THE STOREDSEQUENCECONTEXT ADAPTEE
public class InhStoredSequenceListAdapter extends StoredSequenceContext implements SequenceListStore{

	public InhStoredSequenceListAdapter(CharSequence s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	//We need to implement this method as opposed to all the other methods in the interface
	//Because the other ones are already implemented in the class we're extending, we just need to implement this one correctly
	
	@Override
	public void store(CharSequence[] list) throws Exception {
		for(CharSequence cs: list) {
			super.store(cs);
		}
		
	}

}
