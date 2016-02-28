//Chapter7 - Exercise P7.1

public class CurrencyConversion
{
	private double sum;
	private double count;
	private double euro;
	
	private final double EURO = 0.77;
	
	public CurrencyConversion()
	{
	sum = 0;
	count = 0;
	euro = 0;
	}
	
	public void getSum (double dollar)
	{
	sum = sum + dollar;
	count++;
	}
	
	public double getDollar()
	{
	return sum;
	}
	
	public double getEuro()
	{
	euro = sum*EURO;
	return euro;
	}
}
	
	
	