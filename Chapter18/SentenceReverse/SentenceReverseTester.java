//Chapter 18 - Exercise P18.1

import java.util.Scanner;

public class SentenceReverseTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = in.next();
	
		SentenceReverse greeting = new SentenceReverse(s);
		greeting.reverse();
		System.out.println(greeting.getText());
	}
}