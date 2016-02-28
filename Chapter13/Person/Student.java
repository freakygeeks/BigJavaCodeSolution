//Chapter 13 - Exercise 13.4

public class Student extends Person
{
	private String major;
	
	public Student (String n, int y, String m)
	{
		super(n, y);
		major = m;
	}
	
	public String toString()
	{
		return "Student : " + super.toString() + ", Major = " + major;
	}
}	