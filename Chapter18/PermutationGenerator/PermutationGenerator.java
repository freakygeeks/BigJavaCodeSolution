//Chapter 18 - Example 18.2

import java.util.ArrayList;

public class PermutationGenerator
{
	private String word;
	
	public PermutationGenerator(String aWord)
	{
		word = aWord;
	}
	
	//get all permutation of a given word
	public ArrayList<String> getPermutation()
	{
		ArrayList<String> result = new ArrayList<String>();
		
		if(word.length() == 0)
		{
			result.add(word);
			return result;
		}
		
		//loop through all character positions
		for (int i = 0; i < word.length(); i++)
		{
			String shortWord = word.substring(0, i) + word.substring(i+1); //remove ith character
			
			PermutationGenerator shortPermutation = new PermutationGenerator(shortWord); //get all permutations
			ArrayList<String> shortWordPermutation = shortPermutation.getPermutation();
			
			for (String s : shortWordPermutation)
			{
				result.add(word.charAt(i)+s);
			}
		}
		
		return result;
	}
}