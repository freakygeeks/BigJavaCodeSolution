//Chapter 9 - Example 9

public class Greeter
{
	private String name;
	private String adj;
	
	public Greeter(String aName, String anAdjective)
	{
		name = aName;
		adj = anAdjective;
	}

	public void getGreeting()
	{
		System.out.println(name + ", you are the most " + adj + " person in the world!");
	}
}
