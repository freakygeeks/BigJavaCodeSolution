//Chapter 26 - Exercise 26.1

public class PurseTester
{
	public static void main (String[] args) throws Exception
	{
		PurseParser parser = new PurseParser();
		Purse p = parser.parse("purse.xml");
		System.out.println("Total coin value : " + p.getTotal());
	}
}