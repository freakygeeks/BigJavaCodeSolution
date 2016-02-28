//Chapter 9 - Project 9.2

public class Digit
{
	private String code;
	
	public Digit (String aCode)
	{
		code = aCode;
	}
	
	public int getCode()
	{
		if (code.equals(":::||"))
		{
			return 1;
		}
		else if (code.equals("::|:|"))
		{
			return 2;
		}
		else if (code.equals("::||:"))
		{
			return 3;
		}
		else if (code.equals(":|::|"))
		{
			return 4;
		}
		else if (code.equals(":|:|:"))
		{
			return 5;
		}
		else if (code.equals(":||::"))
		{
			return 6;
		}
		else if (code.equals("|:::|"))
		{
			return 7;
		}
		else if (code.equals("|::|:"))
		{
			return 8;
		}
		else if (code.equals("|:|::"))
		{
			return 9;
		}
		else if (code.equals("||:::"))
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	public boolean isValid()
	{
		return false;
	}
}














