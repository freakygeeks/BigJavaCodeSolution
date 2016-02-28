//Chapter 19 - Exercise 19.4

import java.util.Arrays;

public class MergeLexicographicsTester
{
	public static void main (String[] args)
	{
		String[] a = {"Able", "was", "I", "ere", "I", "saw", "Elba"};
		MergeLexicographics m = new MergeLexicographics(a);
		m.sort();
		System.out.println(Arrays.toString(a));
		System.out.println("Expected: [Able, Elba, I, I, ere, saw, was]");
	}
}