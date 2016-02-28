//Chapter7 - Exercise P7.6

import java.util.Scanner;

public class MeanDeviationTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	MeanDeviation calc = new MeanDeviation();
	
	boolean done = true;
	while (done)
	{
		System.out.print ("Please enter the data value, enter Q to quit : ");
		String input = in.nextLine();
		
		if(input.equalsIgnoreCase("Q"))
		{
			done = false;
		}
		else
		{
			double value = Double.parseDouble(input);
			calc.getSum(value);
		}
	}
	System.out.println ("The mean average value is : " + calc.getMean());
	System.out.println ("The standard deviation value is : " + calc.getDeviation());
	System.out.println ("Total count : " + calc.getCount());
	}
}
	
	