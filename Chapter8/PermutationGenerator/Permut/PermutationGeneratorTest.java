public class PermutationGeneratorTest 
{
	public final static void main(String[] args) 
	{
	int n = 10;//Integer.parseInt(args[10]);

	PermutationGenerator generator = new PermutationGenerator(n);

	int[] p = new int[n];
 
	for (int i=0; i<n; i++)
		{
		System.out.println("The permutation "  + (i+1) + "of numbers between 1 and " + n +": ");

		p = generator.nextPermutation();

		for (int j=0; j<n; j++)
		{
		System.out.print(p[j] + ", ");
		}
	System.out.println("");
		}
	}
}