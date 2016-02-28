//Chapter7 - Example 7.3

public class Triangle
{
	private int width;
	
	public Triangle(int aWidth)
	{
	width = aWidth;
	}
	
	public String toString1()
	{
	String r = " ";
	for (int j = 1; j <= width; j++)
	r = r + "[]";
	r = r + "\n";
	
	return r;
	}	
	
	public String toString2()
	{
	String r = " ";
	for (int i = 1; i <= width; i ++)
		{
		for (int j = 1; j <= i; j++)
		r = r + "[]";
		r = r + "\n";
		}
	return r;
	}
}
