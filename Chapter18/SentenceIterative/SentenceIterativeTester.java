//Chapter 18 - Exercise P18.3

import java.util.Scanner;

public class SentenceIterativeTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		SentenceIterative greeting = new SentenceIterative(s);
		greeting.reverse();
		System.out.println(greeting.getText());
	}
}