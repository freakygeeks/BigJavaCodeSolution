import java.util.Random;

public class BrutePermutationGenerator
{    
	private int[] array = new int[10];
	
	public int[] nextPermutation()
	{
	Random rand = new Random();
	
    for (int j = 0; j < 1; j++)//loop for permutation 10 times
        {
        for (int i = 0; i < 10; i++)//loop for random number between 1 to 10
			{

			int low = 1;
			int high = 10;
			int r = 0;
			int old = 0;
			int range = high - low + 1;
			r = rand.nextInt(range);
			old = r;
			while (old == r)
				{
				r = rand.nextInt(range);
				}
			num[i] = num[r];
            num[r] = i;
			System.out.print(r + " ");
           
		   }

            for (int i = 0; i < 4; i++)// loop for element in array
				{ 
				//System.out.print(num[i] + 1 + " ") ;//+ 1 + " ");
				}

            System.out.println();
        }
    return num;
	}
}