//Chapter 18 - Exercise P18.10
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_10

import java.util.ArrayList;

public class SubsetGenerator
{
	private String word;
	
	public SubsetGenerator (String aWord)
	{
		word = aWord;
	}
	
	public ArrayList<String> getSubsets() 
	{
		ArrayList<String> subsets = new ArrayList<String>();

		if (word.length() == 0) 
		{
			subsets.add(word);
			return subsets;
		}

		// Loop through all character positions
		for (int j = word.length()-1; j >= 0; j--) 
		{
			for (int i = j; i < word.length(); i++) 
			{
				String shorterWord =  word.substring(0, j) ;
				SubsetGenerator shorterPermutationGenerator = new SubsetGenerator(shorterWord);
				ArrayList<String> shorterWordPermutations = shorterPermutationGenerator.getSubsets();
				
				for (String s : shorterWordPermutations) 
				{
					//Subsets.add(word.charAt(i)+s);
					subsets.add(s + word.charAt(i));
				}
			}
		}
		return subsets;
	}
}
