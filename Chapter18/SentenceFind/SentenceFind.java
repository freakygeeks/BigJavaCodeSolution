//Chapter 18 - Exercise P18.4

public class SentenceFind
{
	private String phrase;
	
	public SentenceFind(String aPhrase)
	{
		phrase = aPhrase;
	}
	
	public boolean find (String text)
	{
		return find_helper(text, 0);
	}
	
	private boolean find_helper(String aText, int anIndex)
	{
		if (phrase.length() < aText.length() - anIndex)
		{
			return false;
		}
		
		if (!phrase.contains(aText))
		{
			return false;
		}
		
		if (phrase.substring(anIndex).startsWith(aText))
		{
			return true;
		}
		
		return find_helper(aText, anIndex+1);
	}
}