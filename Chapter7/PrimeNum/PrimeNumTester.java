//Chapter7 - Exercise P7.11

import java.util.Scanner;

public class PrimeNumTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	PrimeNum calc = new PrimeNum();
	
	System.out.print ("Enter number : ");
	String num = in.nextLine();
	int n = Integer.parseInt(num);
	
	calc.getPrime(n);
	}
}
	