//Chapter7 - Example 7.4

import java.util.Scanner;

public class DataSetTester
{
	public static void main (String[] args)	
	{
	Scanner in = new Scanner(System.in);
	DataSet calc = new DataSet();
	
	boolean done = false;
	while (!done) //not false = true
	{
		System.out.print ("Enter value, Q to quit : ");
		String input = in.nextLine();
		if (input.equalsIgnoreCase("Q"))
			done = true; // same value with !done = not false = true
		else
		{
			double x = Double.parseDouble(input);
			calc.add(x);
		}
	}
	
	System.out.println ("Average = " + calc.getAverage());
	System.out.println ("Maximum = " + calc.getMax());
	}
}