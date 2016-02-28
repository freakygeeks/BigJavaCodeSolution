//Chapter6 -  Example 6.3.1
import java.util.Scanner;

public class EarthquakeTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Enter a magnitude on the Richter scale: ");
	double mag = in.nextDouble();
	
	Earthquake quake = new Earthquake(mag);
	System.out.println (quake.getDescription());
	}
}