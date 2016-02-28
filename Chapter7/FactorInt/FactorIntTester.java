//Chapter7 - Exercise P7.10

import java.util.Scanner;

public class FactorIntTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	FactorInt calc = new FactorInt();
	
	System.out.print ("Enter number for factoring : ");
	String num = in.nextLine();
	int n = Integer.parseInt(num);
	
	calc.getFactor(n);
	}
}
	
	