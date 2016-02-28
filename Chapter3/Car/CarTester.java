//Chapter3 - Exercise P3.6
public class CarTester
{
	public static void main (String[] args)
	{
	Car c = new Car();
	c.gas(20);
	c.drive(100);
	
	double newC = c.getGas();
	
	System.out.println("Fuel remaining is : " + newC + " gallons");
	}
}
