//Chapter 18 - Exercise P18.3

public class SentenceIterative
{
	private String phrase;
	private String newPhrase;
	
	public SentenceIterative(String aPhrase)
	{
		phrase = aPhrase;
		newPhrase = "";
	}
	
	public void reverse()
	{
		for (int i = phrase.length()-1; i >= 0; i--)
		{
			char word = phrase.charAt(i);
			newPhrase =  newPhrase + word;
		}
	}
	
	public String getText()
	{
		return newPhrase;
	}
}