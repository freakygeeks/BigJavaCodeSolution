//Chapter 18 - Exercise P18.4

import java.util.Scanner;

public class SentenceFindTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = in.next();
		
		System.out.print("Enter text : ");
		String q = in.next();
		
		SentenceFind greeting = new SentenceFind(s);
		
		boolean n = greeting.find(q);
		System.out.println("Result : " + n);
	}
}
