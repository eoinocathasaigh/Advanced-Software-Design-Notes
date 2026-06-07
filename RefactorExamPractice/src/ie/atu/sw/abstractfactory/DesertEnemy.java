package ie.atu.sw.abstractfactory;

public class DesertEnemy implements Enemy{

	@Override
	public void spawn() {
		System.out.println("desert enemy spawns");
		
	}

	@Override
	public void attack() {
		System.out.println("desert enemy attacks");
		
	}

}