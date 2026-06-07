package ie.atu.sw.builder;

//All that this class is meant to do is test the application
public class Client {
	
	public static void main(String[] args) throws Exception {
		var cd = new CharacterDirector();
		
		//Directing the director to get the sequence and spitting out the result
		for(int i = 33; i < 10000; i++) {
			cd.append((char)i);
		}
		
		//Printing the result here
		System.out.println(cd.getCharSequence());
	}
}
