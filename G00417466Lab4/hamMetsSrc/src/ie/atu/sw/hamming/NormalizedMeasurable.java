package ie.atu.sw.hamming;

import ie.atu.character.Measurable;

public interface NormalizedMeasurable extends Measurable{
	public static final float MIN_RANGE = 0;
	public static final float MAX_RANGE = 1;
	
	@Override
	public default float compare(CharSequence s, CharSequence t) throws Exception {
		System.out.println("Executing NormalizedMeasurable compare()");
		return compare(s, t, MAX_RANGE, MIN_RANGE);
	}
	
	public default float compare(CharSequence s, CharSequence t, float upper, float lower) throws Exception {
		float i = Integer.valueOf(s.length()).floatValue();
		float j = Integer.valueOf(t.length()).floatValue();
		
		float max = Math.max(i, j);
		float min = Math.min(i, j);
		if (max == min) min = 0;
		
		return (Measurable.super.compare(s, t) - min)*(upper - lower)/(max - min) + lower;
	}	
}