//Chapter 26 - Exercise 26.13

public class Country
{
	private String name;
	private int population;
	private double area;
	
	public Country(String aName, int aPopulation, double anArea)
	{
		name = aName;
		population = aPopulation;
		area = anArea;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public double getArea()
	{
		return area;
	}
	
	public double getPopulationDensity()
	{
		return population/area;
	}
}


















