//Chapter7 - Example 7.5

public class NeedleTester
{
	public static void main (String[] args)
	{
	Needle calc = new Needle();
	final int TRY1 = 10000;
	final int TRY2 = 1000000;
	
	for (int i =1; i <= TRY1; i++)
	calc.drop();
	System.out.printf ("Tries = %d, Try/Hit = %8.5f\n", TRY1, (double) calc.getTry()/calc.getHit());
	
	for (int i = TRY1+1; i <= TRY2; i++)
	calc.drop();
	System.out.printf ("Tries = %d, Try/Hit = %8.5f\n", TRY2, (double) calc.getTry()/calc.getHit());
	}
}