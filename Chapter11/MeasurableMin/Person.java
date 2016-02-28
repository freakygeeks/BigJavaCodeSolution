//Chapter11 - Exercise P11.4

public class Person implements Measureble
{
	private double num;
	private String name;
	
	public Person (double aNum, String aName)
	{
	num = aNum;
	name = aName;
	}
	
	public String getName()
	{
	return name;
	}
	
	public double getMax()
	{
	return num;
	}

	public double getMin()
	{
	return num;
	}
}