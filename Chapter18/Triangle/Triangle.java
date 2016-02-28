//Chapter 18 - Example 18.1

public class Triangle
{
	private int width;
	
	public Triangle(int aWidth)
	{
		width = aWidth;
	}
	
	public int getArea()
	{
		if (width <= 0)
		{
			return 0;
		}
		
		if (width == 1)
		{
			return 1;
		}
		
		Triangle smallTriangle = new Triangle(width - 1);
		int smallArea = smallTriangle.getArea();
		System.out.println(smallArea + width + "[]");
		return smallArea + width;
	}
}