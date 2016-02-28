//Chapter4
public class Printed
{
	public static void main (String[] args)
	{
	double total = 3.50;
	final double TAX_RATE = 8.5;
	
	double tax = (total*TAX_RATE)/100;
	
	System.out.println ("Total : " + total);
	System.out.println ("Tax : " + tax);
	
	System.out.printf ("Total:%5.2f", total);
	System.out.println();
	System.out.printf ("%-6s%5.2f%n", "Tax : ", total);
	}
}