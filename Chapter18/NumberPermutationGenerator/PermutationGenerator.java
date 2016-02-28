//Chapter 18 - Exercise 18.12

public class PermutationGenerator
{
	private String word;
	private NumberPermutationGenerator index;
	
	public PermutationGenerator(String aWord)
	{
		word = aWord;
		index = new NumberPermutationGenerator(word.length());
	}
	
	public boolean getMorePermutation()
	{
		return index.hasMorePermutation();
	}
	
	public String getPermutation()
	{
		int[] a = index.nextPermutation();
		String r = "";
		{
		for (int i = 0; i < a.length; i++)
			r = r + word.charAt(a[i]);
		}
		
		return r;
	}
}