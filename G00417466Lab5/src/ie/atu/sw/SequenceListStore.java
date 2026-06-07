package ie.atu.sw;

/*
 * This is the target interface in the Adapter Pattern. The client
 * is dependent on an instance of SequenceListStore being available
 * and the task of an adapter is to handle any of these method calls
 * and do something with them to enable them to be passed on to a
 * non-conforming class (the Adaptee).
 */
public interface SequenceListStore {
	public void open(CharSequence fileName) throws Exception;
	public void store(CharSequence[] list) throws Exception;
	public void close() throws Exception;
}