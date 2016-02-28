//Chapter3 - Exercise P3.6
public class Car
{
	private double fuel;
	
	public Car()
	{
	fuel = 0;
	}
	
	public void gas (double gallon)
	{
	double newGas = this.fuel + gallon;
	this.fuel = newGas;
	}
	
	public void drive (double mile)
	{
	double newDrive = mile/49;
	double result = this.fuel - newDrive;
	this.fuel = result;
	}
	
	public double getGas()
	{
	return this.fuel;
	}
}
	