//Chapter 13 - Exercise 13.5

public class Manager extends Employee
{
	private String department;
	
	public Manager (String n, double s, String d)
	{
		super(n,s);
		department = d;
	}
	
	public String toString()
	{
		return super.toString() + ", Department = " + department;
	}
}