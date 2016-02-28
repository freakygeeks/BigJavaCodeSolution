//Chapter 6 - Exercise P6.10
import java.util.Scanner;

public class LexiViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Enter first strings :");
	String st1 = in.nextLine();
	
	System.out.print ("Enter second strings : ");
	String st2 = in.nextLine();
	
	System.out.print ("Enter third strings : ");
	String st3 = in.nextLine();
	
	System.out.print ("Enter fourth strings : ");
	String st4 = in.nextLine();
	
	Lexi calc = new Lexi(st1, st2, st3, st4);
	System.out.println ("The lexicographic min value is : " + calc.getMin());
	System.out.println ("The lexicographic max value is : " + calc.getMax());
	}
}