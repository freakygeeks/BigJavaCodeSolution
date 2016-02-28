//Chapter8 - Exercise P8.11

import java.util.ArrayList;
import java.util.Random; 

public class SmartPermutationGenerator 
{
    private int size;
    private Random rand = new Random();

    public SmartPermutationGenerator() 
	{
    this.size = 10;
    }

    public ArrayList<Integer> getRandomPermutation() 
	{
    ArrayList<Integer> unused = new ArrayList<>();

    for (int i = 0; i < size; i++) // loop for element in array
		{
        unused.add(i + 1);
        }

    ArrayList<Integer> perm = new ArrayList<>();

    for (int k = 0; k < size; k++)  //loop for random number between 1 to 10
		{
        int pos = rand.nextInt(unused.size());
        perm.add(unused.get(pos));
        unused.remove(pos);
        }

    return perm;
    }

    public void nextPermutation()
	{
    for(int i = 0; i < size; i++) //loop for permutation 10 times
		{
	    for(Integer item : getRandomPermutation()) 
			{
			System.out.print(item + " ");
			}
		System.out.println();
		}
    }
}