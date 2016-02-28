//Chapter 6 - Exercise P6.14

import java.util.Scanner;

public class TwoFloatNumViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Enter first float point : ");
	float input1 = in.nextFloat();
	
	System.out.print ("Enter second float point : ");
	float input2 = in.nextFloat();
	
	TwoFloatNum calc = new TwoFloatNum (input1, input2);
	System.out.println (calc.getFloat());
	}
}