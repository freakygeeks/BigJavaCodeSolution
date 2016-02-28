//Chapter 18 - Exercise P18.9

import java.util.Scanner;

public class SubstringGeneratorTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		SubstringGenerator greeting = new SubstringGenerator(s);
		
		System.out.println("---");
		
		while (greeting.hasMoreSubstring())
		{
			System.out.println(greeting.nextSubstring());
		}
		
		System.out.println("---");
	}
}