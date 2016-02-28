//Chapter 21 - Exercise 21.5

public class Student
{
	private String firstName;
	private String lastName;
	private int id;
	
	public Student(String aFirstName, String aLastName, int anId)
	{
		firstName = aFirstName;
		lastName = aLastName;
		id = anId;
	}
	
	//get student first name
	public String getFirstName()
	{
		return firstName;
	}
	
	//get student last name
	public String getLastName()
	{
		return lastName;
	}
	
	//get student ID
	public int getId()
	{
		return id;
	}
}