//Chapter 18 - Exercise P18.2

public class SentenceReverseHelper
{
	private String phrase;
	private SentenceReverseHelper tailSentence;
	
	public SentenceReverseHelper(String aPhrase)
	{
		phrase = aPhrase;
	}
	
	public String reverse()
	{
		return reverse(0, 1);
	}
	
	public String reverse(int start, int end) //this is the recursive method
	{
		char c;
		String rest;
		
		if (!phrase.equals(""))
		{
			c = phrase.charAt(start);
			rest = phrase.substring(end);
			tailSentence = new SentenceReverseHelper(rest);
			phrase = tailSentence.reverse() + c;
		}
		
		return phrase;
	}
	
	public String getText()
	{
		return phrase;
	}
}