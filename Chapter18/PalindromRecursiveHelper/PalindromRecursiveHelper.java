//Chapter 18 - Example 18.1

public class PalindromRecursiveHelper
{
	private String text;
	
	public PalindromRecursiveHelper(String aText)
	{
		text = aText;
	}
	
	public boolean isPalindrom()
	{
		return isPalindrom(0, text.length()-1);
	}
	
	public boolean isPalindrom(int start, int end) //this is the recursive method
	{
		char first = Character.toLowerCase(text.charAt(start));
		char last = Character.toLowerCase(text.charAt(end));
		
		if (start >= end)
		{
			return true;
		}
		
		if (Character.isLetter(first) && Character.isLetter(last))
		{
			if (first == last)
			{
				return isPalindrom(start+1, end-1);
			}
		
			else
			{
				return false;
			}
		}
		
		else if (!Character.isLetter(last))
		{
			return isPalindrom(start, end-1);
		}
		
		else
		{
			return isPalindrom(start+1, end);
		}
	}
}