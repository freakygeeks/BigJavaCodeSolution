//Chapter 13 - Exercise 13.6

public class Worker
{
	public String name;
	public double salary_rate;
	
	public Worker (String n, double s)
	{
		name = n;
		salary_rate = s;
	}
	
	public String toString()
	{
		return name + " in ";
	}
}