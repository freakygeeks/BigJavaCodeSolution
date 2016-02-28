//Chapter 9 - Project 9.2

public class BarCode
{
	private final int LENGTH = 5;
	private String code;
	
	public BarCode (String aCode)
	{
		code = aCode;
	}
	
	public int getCode()
	{
		if (code.length() != 2+5*LENGTH)
		{
			return -1;
		}
		
		if (!code.substring(0,1).equals("|"))
		{
			return -1;
		}
		
		int i = 1;
		int sum = 0;
		int dsum = 0;
		
		String codeDigit = code.substring(i, i+LENGTH);
		Digit d1 = new Digit(codeDigit);
		int val = d1.getCode();
		i = i + LENGTH;
		
		if (val < 0)
		{
			return -1;
		}
		sum = sum + val * 10000;
		dsum = dsum + val;
		
		codeDigit = code.substring(i, i+LENGTH);
		Digit d2 = new Digit(codeDigit);
		val = d2.getCode();
		i = i + LENGTH;
		
		if (val < 0)
		{
			return -1;
		}
		sum = sum + val * 1000;
		dsum = dsum + val;
		
		codeDigit = code.substring(i, i+LENGTH);
		Digit d3 = new Digit(codeDigit);
		val = d3.getCode();
		i = i + LENGTH;
		
		if (val < 0)
		{
			return -1;
		}
		sum = sum + val * 100;
		dsum = dsum + val;
		
		codeDigit = code.substring(i, i+LENGTH);
		Digit d4 = new Digit(codeDigit);
		val = d4.getCode();
		i = i + LENGTH;
		
		if (val < 0)
		{
			return -1;
		}
		sum = sum + val * 10;
		dsum = dsum + val;
		
		codeDigit = code.substring(i, i+LENGTH);
		Digit d5 = new Digit(codeDigit);
		val = d5.getCode();
		i = i + LENGTH;
		
		if (val < 0)
		{
			return -1;
		}
		sum = sum + val;
		dsum = dsum + val;
		
		codeDigit = code.substring(i, i+LENGTH);
		Digit d6 = new Digit(codeDigit);
		val = d6.getCode();
		i = i + LENGTH;
		
		if (val < 0)
		{
			return -1;
		}
		dsum = dsum + val;
		
		if (dsum % 10 != 0)
		{
			return -1;
		}
		
		if (!code.substring(i, i+1).equals("|"))
		{
			return -1;
		}
		
		return sum;
	}
	
	public boolean isValid()
	{
		return true;
	}
}
























