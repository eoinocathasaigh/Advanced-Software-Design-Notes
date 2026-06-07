package ie.atu.sw.abstractfactory;

public class ForestEnemy implements Enemy{

	@Override
	public void spawn() {
		System.out.println("spawning enemy in forest");
		
	}

	@Override
	public void attack() {
		System.out.println("enemy attacks in forest");
		
	}

}