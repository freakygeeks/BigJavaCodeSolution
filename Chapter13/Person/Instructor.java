//Chapter 13 - Exercise 13.4

public class Instructor extends Person
{
	private double salary;
	
	public Instructor (String n, int y, double s)
	{
		super(n, y);
		salary = s;
	}
	
	public String toString()
	{
		return "Instructor : " + super.toString() + ", Salary = " + salary;
	}
}