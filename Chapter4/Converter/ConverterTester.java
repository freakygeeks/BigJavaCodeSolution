//Chapter4 - Exercise P4.7
import java.util.Scanner;

public class ConverterTester
{
	public static void main (String[] args)
	{
	Converter calc = new Converter();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter the meter value : ");
	double val = in.nextDouble();
	
	calc.insert(val);
	
	System.out.println ("The conversion from meter to mile : " + calc.getMile() + " mile");
	System.out.println ("The conversion from meter to feet : " + calc.getFeet() + " feet");
	System.out.println ("The conversion from meter to inch : " + calc.getInch() + " inch");
	}
}