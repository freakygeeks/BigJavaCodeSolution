//Chapter 18 - Exercise 18.12

import java.util.Scanner;

public class PermutationGeneratorTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		PermutationGenerator greeting = new PermutationGenerator(s);
		
		while (greeting.getMorePermutation())
		{
			System.out.println(greeting.getPermutation());
		}
		System.out.println(s);
	}
}