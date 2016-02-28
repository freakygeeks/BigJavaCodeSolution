//Chapter4 - Exercise P4.9
import java.util.Scanner;

public class SodaCanTester
{
	public static void main (String[] args)
	{
	SodaCan calc = new SodaCan();
	Scanner in = new Scanner(System.in);
	
	System.out.println("Please enter the radius of cylinder : ");
	double rad = in.nextDouble();
	System.out.println("Please enter the height of cylinder : ");
	double hei = in.nextDouble();
	
	calc.insert(rad,hei);
	
	System.out.println ("The cylinder volume are : " + calc.getVolume());
	System.out.println ("The cylinder area are : " + calc.getArea());
	}
}