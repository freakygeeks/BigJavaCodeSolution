public class PermutationIterator
{
	private String word;
	private String tail;
	
	public PermutationIterator(String aTail, String aWord)
	{
		tail = aTail;
		word = aWord;
	}
	
	public void nextPermutation()
	{
		nextPermutation(tail, word);
	}
	
	public void nextPermutation(String t, String w)
	{
		int n = w.length();
		
		if (n == 0)
		{
			System.out.println(t);
		}
		
		else
		{
			for (int i = 0; i < n; i++)
			{
				nextPermutation(t + w.charAt(i), w.substring(0, i) + w.substring(i+1));
			}
		}
	}
}
