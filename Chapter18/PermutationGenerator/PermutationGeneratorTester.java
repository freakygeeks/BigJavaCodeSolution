//Chapter 18 - Example 18.2

import java.util.Scanner;

import java.util.ArrayList;

public class PermutationGeneratorTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		PermutationGenerator gen = new PermutationGenerator(s);
		ArrayList<String> permut = gen.getPermutation();
		
		for (String a : permut)
		{
			System.out.println(a);
		}
	}
}