//Chapter 18 - Exercise P18.2

import java.util.Scanner;

public class SentenceReverseHelperTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		SentenceReverseHelper greeting = new SentenceReverseHelper(s);
		greeting.reverse();
		System.out.println(greeting.getText());
	}
}