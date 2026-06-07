package ie.atu.sw.abstractfactory;

public class ForestBiomeFactory implements BiomeFactory {
	@Override
	public Enemy createEnemy() {
		return new ForestEnemy();
	}

	@Override
	public Loot dropLoot() {
		return new ForestLoot();
	}

	@Override
	public Obstacle placeObstacle() {
		return new ForestObstacle();
	}

	@Override
	public Enemy spawnEnemy() {
		// TODO Auto-generated method stub
		return null;
	}
}