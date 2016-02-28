//Chapter 13 - Exercise 13.5

public class Employee
{
	private String name;
	private double salary;
	
	public Employee (String n, double s)
	{
		name = n;
		salary = s;
	}
	
	public String toString()
	{
		return "Employee : Name = " + name + ", Salary = " + salary;
	}
}