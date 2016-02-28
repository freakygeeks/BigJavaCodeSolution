//Chapter 19 - Exercise 19.12
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch14/c14_exp_14_12

public class Person
{
	private String name;
	
	public Person (String aName)
	{
		name = aName;
	}
	
	public int compareTo (Object otherObject)
	{
		Person other = (Person)otherObject;
		
		if (name.compareTo(other.name) < 0)
		{
			return -1;
		}
		
		if (name.compareTo(other.name) == 0)
		{
			return 0;
		}
		
		return 1;
	}
	
	public String getName()
	{
		return name;
	}
}
