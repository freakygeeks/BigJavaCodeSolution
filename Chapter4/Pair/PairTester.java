//Chapter4 - Exercise P4.4
import java.util.Scanner;

public class PairTester
{
	public static void main (String[] args)
	{
	Pair compute = new Pair();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Enter first value : ");
	double first = in.nextDouble();
	
	System.out.println ("Enter second value : ");
	double second = in.nextDouble();
	
	compute.getSum(first,second);
	
	System.out.println ("\n");
	System.out.println ("The total sum are : " + compute.resultSum());
	System.out.println ("The total average are : " + compute.resultAverage());
	System.out.println ("The different value are : " + Math.abs(first-second));
	System.out.println ("The maximum number are : " + Math.max(first, second));
	System.out.println ("The minimum number are : " + Math.min(first, second));
	}
}