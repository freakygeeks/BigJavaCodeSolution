//Chapter 18 - Example 18.1
//http://www.mathcs.emory.edu/~dsavenk/courses/fall13/cs170/classcode/IsPalindrome.java

public class PalindromRecursive
{
	private String text;
	
	public PalindromRecursive (String aText)
	{
		text = aText;
	}
	
	public boolean isPalindrom()
	{
		int length = text.length();
		char first = Character.toLowerCase(text.charAt(0));
		char last = Character.toLowerCase(text.charAt(length-1));
		
		if (length <= 1)
		{
			return true;
		}
		
		if (Character.isLetter(first) && Character.isLetter(last))
		{
			if (first == last)
			{
				PalindromRecursive palim = new PalindromRecursive(text.substring(1, length-1));
				return palim.isPalindrom();
			}
		
			else
			{
				return false;
			}
		}
		
		else if (!Character.isLetter(last))
		{
			PalindromRecursive palim = new PalindromRecursive(text.substring(0, length-1));
			return palim.isPalindrom();
		}
		
		else
		{
			PalindromRecursive palim = new PalindromRecursive(text.substring(1));
			return palim.isPalindrom();
		}
	}
}