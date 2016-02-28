import java.util.Scanner;

public class PermutationIteratorTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		PermutationIterator greeting = new PermutationIterator("",s);
		greeting.nextPermutation();
		
		/*while (greeting.hasMorePermutation())
		{
			System.out.println(greeting.nextPermutation());
		}*/
	}
}