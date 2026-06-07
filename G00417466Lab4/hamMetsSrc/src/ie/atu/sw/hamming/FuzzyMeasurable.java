package ie.atu.sw.hamming;

import ie.atu.character.Measurable;

public interface FuzzyMeasurable extends Measurable{

	public default float compare(CharSequence s, CharSequence t) throws Exception{
		return Measurable.super.compare(s, t) / 
				Math.max(Integer.valueOf(s.length()).floatValue(), Integer.valueOf(t.length()).floatValue());
	}
}