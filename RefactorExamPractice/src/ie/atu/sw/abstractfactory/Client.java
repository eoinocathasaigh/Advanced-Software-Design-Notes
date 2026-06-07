package ie.atu.sw.abstractfactory;

public class Client {

	public static void main(String[] args) {
		BiomeFactory forFac = new ForestBiomeFactory();
		BiomeFactory desFac = new DesertBiomeFactory();
		
		GameLevel forLevel = new GameLevel(forFac);
		GameLevel desLevel = new GameLevel(desFac);
		
		forLevel.load();
		desLevel.load();
	}
}