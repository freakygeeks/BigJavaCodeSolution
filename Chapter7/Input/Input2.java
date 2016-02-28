//Chapter7 - Example Advanced 7.1

import java.util.Scanner;

public class Input2
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	boolean done = false;
	while (!done)
	{
		System.out.println ("Please enter a positive number : ");
		double value = in.nextDouble();
		if (value > 0) 
			done = true;
	}
	}
}