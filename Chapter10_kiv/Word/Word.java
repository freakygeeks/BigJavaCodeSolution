//Chapter10 - Example 10.7

public class Word
{
	private String text;
	
	public Word (String s)
	{
	int i = 0;
	while ( i < s.length() && !Character.isLetter(s.charAt(i)))
		i++;
	
	int j = s.length() - 1;
	while (j > i && !Character.isLetter(s.charAt(j)))
		j--;
	
	text = s.substring(i, j);
	}
	
	public String getText()
	{
	return text;
	}
	
	public int countSyllables()
	{
	int count = 0;
	int end = text.length()-1;
	if (end < 0) return 0;
	
	char ch = Character.toLowerCase(text.charAt(end));
	if (ch == 'e') end--;
	
	boolean insideVowelGroup = false;
	for (int i = 0; i <= end; i++)
		{
		ch = Character.toLowerCase(text.charAt(i));
		if ("aeiouy".indexOf(ch) >= 0)
			{
			if (!insideVowelGroup)
				{
				count++;
				insideVowelGroup = true;
				}
			}
		}
	
	if (count == 0)
		{
		count = 1;
		}
	
	return count;
	}
}