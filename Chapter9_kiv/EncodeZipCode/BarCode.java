//Chapter 9 - Project 9.2

public class BarCode
{
	private int zip;
	
	public BarCode (int n)
	{
		zip = n;
	}
	
	public String getCode()
	{
		String barCode = "|";
		int sum = 0;
		int temp = 0;
		
		temp = zip/10000;
		sum = sum + temp;
		Digit d1 = new Digit(temp);
		barCode = barCode + d1.getCode();
		zip = zip % 10000;
		
		temp = zip/1000;
		sum = sum + temp;
		Digit d2 = new Digit(temp);
		barCode = barCode + d2.getCode();
		zip = zip % 1000;
		
		temp = zip/100;
		sum = sum + temp;
		Digit d3 = new Digit(temp);
		barCode = barCode + d3.getCode();
		zip = zip % 100;
		
		temp = zip/10;
		sum = sum + temp;
		Digit d4 = new Digit(temp);
		barCode = barCode + d4.getCode();
		zip = zip % 10;
		
		temp = zip;
		sum = sum + temp;
		Digit d5 = new Digit(temp);
		barCode = barCode + d5.getCode();
		
		temp = 10 - (sum % 10);
		Digit d6 = new Digit(temp);
		barCode = barCode + d6.getCode() + "|";
		
		return barCode;
	}
}














