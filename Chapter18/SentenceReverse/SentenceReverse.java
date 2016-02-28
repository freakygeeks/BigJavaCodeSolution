//Chapter 18 - Exercise P18.1

public class SentenceReverse
{
	private String phrase;
	private SentenceReverse tailSentence;
	
	public SentenceReverse(String aPhrase)
	{
		phrase = aPhrase; //get the string text
	}
	
	public String reverse()
	{
		char c; //define temp char 
		String rest; //define temp string
		
		if (!phrase.equals("")) //if string text != null
		{
			c = phrase.charAt(0);//allocate temp char with the first char of temp string
			rest = phrase.substring(1); //allocate the next temp string substring starting with [1]
			tailSentence = new SentenceReverse(rest); //put the temp string into the SentenceReverse class again --> this is the recursion
			phrase = tailSentence.reverse() + c; //allocate the new string in SentenceReverse which call the method reverse() with addition of temp char
		}
		
		return phrase; //return the string each time the method is call;
	}
	
	public String getText()
	{
		return phrase; //return all string
	}
}