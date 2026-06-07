package ie.atu.sw;

//This is an interface meant to demonstrate the generic type
public interface Visitable<T> {
	//What the T refers to here is the ability to pass whatever class is needed into this method
	public default void accept(Visitor<T> v) {
		v.visit(this);
	}

	public T getValue();

	public void setValue(T val);
}