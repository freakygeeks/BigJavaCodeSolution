//Chapter 18 - Exercise P18.5
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_5

public class SentenceIndexOf
{
	private String phrase;
	private String subPhrase;
	private int position;
	private boolean found;
	
	public SentenceIndexOf(String aPhrase)
	{
		phrase = aPhrase;
		subPhrase = "";
		position = 0;
		found = false;
	}
	
	public int indexOf (String text)
	{
		return indexOf_helper(text);
	}
	
	private int indexOf_helper(String aText)
	{
		int possibleFind = -1;
		
		if (subPhrase == "")
		{
			subPhrase = aText;
		}
		
		if (position == phrase.length())
		{
			position--;
			return -1;
		}
		
		if ((phrase.charAt(position) == aText.charAt(0)) || (phrase.charAt(position) == subPhrase.charAt(0)))
		{
			if ((phrase.charAt(position) != aText.charAt(0)) && (phrase.charAt(position) == subPhrase.charAt(0)))
			{
				aText = subPhrase;
			}
			
			if (aText.length() == 1)
			{
				position--;
				return position + 1;
			}
			
			position++;
			possibleFind = indexOf(aText.substring(1, aText.length()));
			
			if (found)
			{
				position--;
				return possibleFind;
			}
			
			if (possibleFind > -1)
			{
				if (aText.length() == subPhrase.length())
				{
					found = true;
				}
				
				if (possibleFind == position + 1)
				{
					position--;
					return position + 1;
				}
				
				else
				{
					position--;
					return possibleFind;
				}
			}
			
			else
			{
				position--;
				return -1;
			}
		}
		
		else
		{
			position++;
			possibleFind = indexOf(subPhrase);
			
			if (possibleFind > -1)
			{
				found = true;
				position--;
				return possibleFind;
			}
		}
		
		position--;
		return -1;
	}	
}

















