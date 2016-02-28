//Chapter 6 - Exercise P6.7

import java.util.Scanner;

public class InputCheckerViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Do you want to continue? : ");
	String input = in.nextLine();
	
	InputChecker calc = new InputChecker(input);
	System.out.println (calc.getCheck());
	}
}