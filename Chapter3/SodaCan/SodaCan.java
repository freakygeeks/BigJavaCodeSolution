//Chapter3 - Exercise P3.11
/*Calculate circle area = (n/360)*(pi*r^2) where n = sector degree, pi = 3.14159, r = radius
  Calculate volume = H*(pi*r^2)*/
  
public class SodaCan
{
	private double area;
	private double volume;
	
	public SodaCan()
	{
	area = 0;
	volume = 0;
	}
	
	public void addVolume (double radius, double height)
	{
	double newArea = this.area + (Math.PI*(radius*radius));
	this.area = newArea;
	
	double newVolume = this.volume + (this.area*height);
	this.volume = newVolume;
	}
	
	public double getArea ()
	{
	return this.area;
	}
	
	public double getVolume()
	{
	return this.volume;
	}
}
	
	