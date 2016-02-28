import java.util.Random;

public class PermutationGenerator 
{
	private int permut[];

	public PermutationGenerator(int n) //@param int the number of numbers in the permutations
	{
	permut = new int[n];
	}

	public int[] nextPermutation() //Generate a permutation,@return int[] the permutation of numbers 1 to n
	{ 
	Random generator = new Random();// Create a random generator

	int n = permut.length;
	for (int i=0; i<n; i++) 
		{
		while (true) 
			{
			int nextRandomNumber = generator.nextInt(n)+1;// Generate a random number between 1 and n
			boolean next = true;
			for (int j=0; j<i; j++)
				{
					if (permut[j]==nextRandomNumber) 
						{
						next = false;
						break;
						}
					if (next) 
						{
						permut[i] = nextRandomNumber;
						break;
					}
				}
			}
		}
	return permut;
	}
}