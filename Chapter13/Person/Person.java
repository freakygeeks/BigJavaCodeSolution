//Chapter 13 - Exercise 13.4
//https://gist.github.com/jimmykurian/2027006

public class Person
{
	private String name;
	private int year;
	
	public Person (String n, int y)
	{
		name = n;
		year = y;
	}
	
	public String toString()
	{
		return "Person : Name = " + name + ", Year of Birth = " + year;
	}
}