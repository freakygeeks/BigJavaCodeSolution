//Chapter 18 - Example 18.1

import java.util.Scanner;

public class PalindromIterativeTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Please enter a string : ");
		String s = in.next();
		
		PalindromIterative drom = new PalindromIterative(s);
		
		if (drom.isPalindrom())
		{
			System.out.println(s + " is a palindrom");
		}
		
		else
		{
			System.out.println(s + " is not a palindrom");
		}
	}
}