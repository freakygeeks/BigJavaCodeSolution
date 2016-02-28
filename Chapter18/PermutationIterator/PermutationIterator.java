//Chapter 18 - Exercise P18.11
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_11
//http://www.tech.theplayhub.com/use_recursion_to_find_permutations_of_string_using_an_iterator/

public class PermutationIterator
{
	private String word;
	private String tail;
	
	public PermutationIterator(String aTail, String aWord)
	{
		tail = aTail;
		word = aWord;
	}
	
	public String nextPermutation()
	{
		return nextPermutation(tail, word);
	}
	
	public String nextPermutation(String t, String w)
	{
		int n = w.length();
		
		if (n == 0)
		{
			System.out.println(t);
			return t;
		}
		
		else
		{
			for (int i = 0; i < n; i++)
			{
				nextPermutation(t + w.charAt(i), w.substring(0, i) + w.substring(i+1));
			}
		}
		return t;
	}
}



