//Chapter 26 - Exercise 26.3

public class PurseTester
{
	public static void main (String[] args) throws Exception
	{
		PurseParser parser = new PurseParser();
		Purse p = parser.parse("purse.xml");
		System.out.println("Total coin value : " + p.getTotal());
	}
}