package ie.atu.sw.facade;

public class Client {
	public static void main(String[] args) {
		
		HomeTheatreFacade htf = new HomeTheatreFacade(new Amplifier(),
													  new DVDPlayer(),
													  new Projector());
		
		htf.watchMovie("Django");
		
		htf.endMovie();
	}
}