//Chapter11 - Exercise P11.3

public class Person implements Measure
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

}