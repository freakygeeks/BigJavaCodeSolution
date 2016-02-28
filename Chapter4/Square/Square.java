//Chapter4 - Exercise P4.10
public class Square
{
	public static final double PIE = 3.142;
	private double length;
	
	public Square()
	{
	length = 0;
	}
	
	public void insert (double len)
	{
	this.length = this.length + len;
	}
	
	public double getArea()
	{
	double area = (double)(Math.pow(length,2));
	return area;
	}
	
	public double getPerimeter()
	{
	double perimeter = (double)(4*length);
	return perimeter;
	}
	
	public double getDiagonal()
	{
	double diagonal = (double)(length*Math.sqrt(2));
	return diagonal;
	}
}