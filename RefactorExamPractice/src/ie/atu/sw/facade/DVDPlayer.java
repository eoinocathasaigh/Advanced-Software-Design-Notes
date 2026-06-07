package ie.atu.sw.facade;

public class DVDPlayer {
	public void on() {
		System.out.println("DVD player has been turned on");
	}
	
	public void play(String movie) {
		System.out.println("DVD is now playing " + movie);
	}
	
	public void off() {
		System.out.println("DVD player has been turned off");
	}
	
	public void pause() {
		System.out.println("Movie has been paused");
	}
	
	public void stop() {
		System.out.println("Movie has been stopped");
	}
}