//Chapter3 - Exercise P3.10
/* Calculate square area = a^2 where a = side perimeter, Calculate square perimeter = 4a */

public class CalcSquare
{
	private double area;
	private double perimeter;
	
	public CalcSquare()
	{
	area = 0;
	perimeter = 0;
	}
	
	public void addAreaPerimeter (double value1)
	{
	double newArea = this.area + (value1*value1);
	this.area = newArea;
	
	double newPerimeter = this.perimeter + (4*value1);
	this.perimeter = newPerimeter;
	}
	
	/*public void addPerimeter (double value2)
	{
	double newPerimeter = this.perimeter + (4*value2);
	this.perimeter = newPerimeter;
	}*/
	
	public double getArea()
	{
	return this.area;
	}
	
	public double getPerimeter()
	{
	return this.perimeter;
	}
}