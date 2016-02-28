//Chapter 18 - Exercise P18.9

public class SubstringGenerator
{
	private String word;
	private String tail;
	private int current;
	private SubstringGenerator tailGenerator;
	private boolean addFirst;
	
	public SubstringGenerator(String aWord)
	{
		word = aWord;
		current = 0;
		
		if (word.length() > 0) //if word is not null
		{
			tailGenerator = new SubstringGenerator(word.substring(1)); //allocate a substring[1] of each word in new class
		}
	}
	
	public String nextSubstring()
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
			return tailGenerator.nextSubstring();//return the next recursion method to calculate the next tailGenerator input
		}
	}
	
	public boolean hasMoreSubstring()
	{
		//return if total char is less or same with total word OR next tailGenerator string is not null AND next tailGenerator repeat it method
		return current <= word.length() || tailGenerator != null && tailGenerator.hasMoreSubstring();
	}
}













