package ie.atu.sw.abstractfactory;

public class GameLevel {
	private Enemy enemy;
	private Loot loot;
	private Obstacle obstacle;
	
	public GameLevel(BiomeFactory bf) {
		this.enemy = bf.createEnemy();
		this.loot = bf.dropLoot();
		this.obstacle = bf.placeObstacle();
	}

	public void load() {
		enemy.attack();
		enemy.spawn();
		obstacle.place();
	}
}