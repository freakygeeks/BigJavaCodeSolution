//Chapter4 - Exercise 4.15
import java.util.Scanner;

public class LargeLetterTester
{
	public static void main (String[] args)
	{
	LargeLetter calc = new LargeLetter();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Large letter H as below : ");
	System.out.println (calc.getLetterH());
	
	System.out.println ("Large letter E as below : ");
	System.out.println (calc.getLetterE());
	
	System.out.println ("Large letter L as below : ");
	System.out.println (calc.getLetterL1());
	
	System.out.println ("Large letter L as below : ");
	System.out.println (calc.getLetterL2());
	
	System.out.println ("Large letter O as below : ");
	System.out.println (calc.getLetterO());
	}
}