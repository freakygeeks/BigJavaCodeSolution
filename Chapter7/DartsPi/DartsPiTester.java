//Chapter7 - Exercise P7.16

public class DartsPiTester
{
	public static void main (String[] args)
	{
	DartsPi calc = new DartsPi();
	final int TRY1 = 10000;
	final int TRY2 = 100000;
	
	for (int i = 1; i <= TRY1; i++)
		calc.getThrown();
		System.out.printf ("Tries = %d, Try/Hit = %8.5f\n", TRY1, (double) calc.getTries()/calc.getHit());
		
	for (int i = TRY1+1; i <= TRY2; i++)
		calc.getThrown();
		System.out.printf ("Tries = %d, Try/Hit = %8.5f\n", TRY2, (double) calc.getTries()/calc.getHit());
	}
}