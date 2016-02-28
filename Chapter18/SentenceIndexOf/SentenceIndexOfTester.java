//Chapter 18 - Exercise P18.5

import java.util.Scanner;

public class SentenceIndexOfTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Enter string : ");
		String s = in.nextLine();
		
		System.out.print("Enter text : ");
		String q = in.nextLine();
		
		SentenceIndexOf greeting = new SentenceIndexOf(s);
		
		int n = -1;
		
		n = greeting.indexOf(q);
		
		if (n > -1)
		{
			System.out.println("The substring was found at position : " + n);
		}
		else
		{
			System.out.println("The substring was not found.");
		}
	}
}