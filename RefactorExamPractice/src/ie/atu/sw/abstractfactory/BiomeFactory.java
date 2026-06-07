package ie.atu.sw.abstractfactory;

//abstract factory
public interface BiomeFactory {
	Enemy createEnemy();
	Enemy spawnEnemy();
	Obstacle placeObstacle();
	Loot dropLoot();
}