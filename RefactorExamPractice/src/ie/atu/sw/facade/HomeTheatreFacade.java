package ie.atu.sw.facade;

public class HomeTheatreFacade {

	private Amplifier amp;
	private DVDPlayer dvd;
	private Projector projector;

	public HomeTheatreFacade(Amplifier amp, DVDPlayer dvd, Projector projector) {
		this.amp = amp;
		this.dvd = dvd;
		this.projector = projector;
	}

	public void watchMovie(String movie) {
		System.out.println("\nGet ready to watch " + movie + "...");
		amp.on();
		amp.setVolume(5);
		dvd.on();
		dvd.play(movie);
		projector.on();
		System.out.println("Enjoy your movie!\n");
	}

	public void endMovie() {
		System.out.println("\nShutting movie theater down...");
		projector.off();
		dvd.stop();
		dvd.off();
		amp.off();
		System.out.println("Movie night is over.\n");
	}
}