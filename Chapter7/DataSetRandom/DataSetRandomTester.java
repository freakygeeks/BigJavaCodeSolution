//Chapter7 - Exercise P7.15

public class DataSetRandomTester
{
	public static void main (String[] args)
	{
	DataSetRandom calc = new DataSetRandom();
	calc.getRandomNum();
	System.out.println ("\n" + "This program is used to generate 100 random number between 0 until 1000");
	System.out.println ("Sum of random number is : " + calc.getSum());
	System.out.println ("Average of random number is : " + calc.getAverage());
	System.out.println ("Maximum random number is : " + calc.getMax());
	System.out.println ("Minimum random number is : " + calc.getMin());
	}
}