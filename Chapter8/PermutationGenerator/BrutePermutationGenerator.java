//Chapter8 - Exercise P8.11

import java.util.Random;

public class BrutePermutationGenerator
{    

	public int[] getRandomPermutation()
    {
    Random rand = new Random();
	int[] array = new int[10];
		
	int r = 0;
	int count = 0;
	boolean fill;
	
	int low = 1;
	int high = 10;
	int range = high - low + 1;
	
	do{
		fill = true;
		r = rand.nextInt(10) + 1;

		for (int i = 0; i < array.length; i++)//loop for random number between 1 to 10
		{			
			if (array[i] == r)
			{
				fill = false;
			}
		}
		
		if (fill == true)
		{
			array[count] = r;
			count++;
		}
	}
	while (count < 10);
		for (int i = 0; i < array.length; i++)//loop for element in array
		{
			System.out.print(array[i] + " ");
		}	
	return array;
	} 
	
	public void nextPermutation()
	{
	for (int i = 0; i < 10; i++) //loop for permutation 10 times
		{
		getRandomPermutation();
		System.out.println();
		
		}
	}
}    