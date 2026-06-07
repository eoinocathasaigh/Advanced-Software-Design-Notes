package ie.atu.sw.facade;

public class Amplifier {
	public void on() {
		System.out.println("TV has turned on");
	}
	
	public void off() {
		System.out.println("TV has turned off");
	}
	
	public void setVolume(int level) {
		System.out.println("TV has been set to volume : " + level);
	}
}