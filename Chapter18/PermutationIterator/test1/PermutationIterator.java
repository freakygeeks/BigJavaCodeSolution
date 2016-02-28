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
		tail = word.charAt(current) + "";
		System.out.print("char " + word.charAt(0) + " ");
		
		if (word.length() > 1)
		{
			tailIterator = new PermutationIterator(word.substring(current+1));
		}
		
	}
	
	public String nextPermutation()
	{
		
		if (word.length() == 1)
		{
			current++;
			return word; //return single char when word is only one char at the end of the result
		}
		
		
		if (tailIterator.hasMorePermutation())
		{
			return tail + tailIterator.nextPermutation();
		}
		
		
		else
		{
			current++;

			tail = word.charAt(current) + ""; //hold value of char based on count
			String tailString = word.substring(0, current) + word.substring(current+1);//combine the char
			
			//System.out.println("tailstring : " + tailString);

			tailIterator = new PermutationIterator(tailString);//put the combine char to be permut again
			return tail + tailIterator.nextPermutation(); //return the result of tail
			
		}
	}	
	
	public boolean hasMorePermutation()
	{
		return current < word.length() - 1;
	}
}


