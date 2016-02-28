//Chapter 9 - Project 9.2

public class Digit
{
	public int zip;
	
	public Digit (int n)
	{
		zip = n;
	}
	
	public String getCode()
	{
		String bar = "";
		
		if (zip == 1)
		{
			bar = ":::||";
		}
		else if (zip == 2)
		{
			bar = "::|:|";
		}
		else if (zip == 3)
		{
			bar = "::||:";
		}
		else if (zip == 4)
		{
			bar = ":|::|";
		}
		else if (zip == 5)
		{
			bar = ":|:|:";
		}
		else if (zip == 6)
		{
			bar = ":||::";
		}
		else if (zip == 7)
		{
			bar = "|:::|";
		}
		else if (zip == 8)
		{
			bar = "|::|:";
		}
		else if (zip == 9)
		{
			bar = "|:|::";
		}
		else
		{
			bar = "||:::";
		}
		
		return bar;
	}
}





















