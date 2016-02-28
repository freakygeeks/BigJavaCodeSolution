//Chapter7 - Exercise P7.1

import java.util.Scanner;

public class CurrencyConversionViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner (System.in);
	CurrencyConversion convert = new CurrencyConversion();
	
	//boolean done = true;//boolean instruction is set to true
	//while (done) //if it true, keep iterating
	boolean done = false;//boolean instruction is set to false
	while (!done) //if it false, keep iterating
	{
		System.out.print ("Enter dollar value, Q to quit.. ");
		String input = in.nextLine();
		System.out.println ("Total dollar currency is : " + convert.getEuro());
		if (input.equalsIgnoreCase("Q"))
			//done = false;//if it false, terminate
			done = true;//if it true, terminate
		else
		{
			double value = Double.parseDouble(input);
			convert.getSum(value);
		}
	}
	
	System.out.println ("Total dollar currency is : " + convert.getDollar());
	System.out.println ("Total conversion to euro is : " + convert.getEuro());
	}
}