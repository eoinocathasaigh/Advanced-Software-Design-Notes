package ie.atu.character;

//This class is meant to implement the levenshtein string measurement method - measuring difference between 2 strings
//It uses the inherited abstract method from the Measurable interface and applies the appropriate behaviour
public class Levenshtein implements Measurable{
	
	//Important that we override its behaviour
	@Override
	public float getDistance(CharSequence s, CharSequence t) throws Exception {
        float[][] distance = new float[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) distance[i][0] = i;
        for (int j = 0; j <= t.length(); j++) distance[0][j] = j;

        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
                distance[i][j] = Math.min(distance[i - 1][j] + 1, Math.min(distance[i][j - 1] + 1, distance[i - 1][j - 1] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1)));
            }
        }
        return distance[s.length()][t.length()];
	}
}