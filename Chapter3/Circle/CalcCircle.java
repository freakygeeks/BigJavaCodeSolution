//Chapter3 - Exercise P3.9
/*Calculate circle area = (n/360)*(pi*r^2) where n = sector degree, pi = 3.14159, r = radius
  Calculate circle perimeter = pi*d or 2pi*r where d = diameter */
  
public class CalcCircle
{
	private double sector;
	private double radius;
	private double pi;
	
	public CalcCircle()
	{
	sector = 0;
	radius = 0;
	pi = 3.14159; //use Math.PI instead of using variable here
	}
		
	public void addArea(double sect, double rad1)
	{
	double newArea = this.sector + (sect/360)*(Math.PI*(rad1*rad1));
	this.sector = newArea;
	}
	
	public void addPerimeter (double rad2)
	{
	double newPerimeter = this.radius + (2*this.pi*rad2);
	this.radius = newPerimeter;
	}
	
	public double getArea()
	{
	return this.sector;
	}
	
	public double getPerimeter()
	{
	return this.radius;
	}
}