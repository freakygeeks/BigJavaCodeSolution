//Chapter7 - Example 7.5

public class DieTester
{
	public static void main (String[] args)
	{
	Die calc = new Die(6);
	final int TRY = 10;
	
	for (int i =1; i<= TRY; i++)
	{
		int n = calc.cast();
		System.out.print (n + " " );
	}
	System.out.println();
	}
}