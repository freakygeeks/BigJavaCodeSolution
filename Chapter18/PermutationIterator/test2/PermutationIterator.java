public class PermutationIterator
{
	private String word;
	private String tail;
	private int current;
	private PermutationIterator tailIterator;
	
	public PermutationIterator(String aWord)
	{
		word = aWord;
		current = 0;
		
		if (word.length() > 0) //if word is not null
		{
			tailIterator = new PermutationIterator(word.substring(1)); //allocate a substring[1] of each word in new class
		}
	}
	
	public String nextPermutation()
	{
		current++; //calculate the string total char
		System.out.print(current + " ");
		
		if (word.length() == 0) //if word is null
		{
			return ""; //return ""
		}
		
		if (current <= word.length()) //if total char is less or same with input
		{
			return word.substring(0, current); //return string start with 0 until the total char
		}
		
		else //other than that
		{
			return tailIterator.nextPermutation();//return the next recursion method to calculate the next tailGenerator input
		}
	}	
	
	public boolean hasMorePermutation()
	{
		return current <= word.length() || tailIterator != null && tailIterator.hasMorePermutation();
	}
}
