//Chapter11 - Exercise P11.1

public class DieTester
{
	public static void main (String[] args)
	{
	DataSet dieData = new DataSet();
	final int TRY = 10;
	
	for (int i =1; i<= TRY; i++)
	{
		dieData.add(new Die());
	}
	System.out.println();
		
	Measure max = dieData.getMax();
	
	System.out.println ("Max is : " + max.getMax());
	System.out.println ("Average is : " + dieData.getAverage());
	}
}