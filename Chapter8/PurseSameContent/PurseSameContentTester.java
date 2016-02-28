//Chapter8 - Exercise P8.5

public class PurseSameContentTester
{
	public static void main (String[] args)
	{
	PurseSameContent a = new PurseSameContent();
	
	a.addCoin("Quarter");
	a.addCoin("Dime");
	a.addCoin("Nickel");
	a.addCoin("Dime");
	
	PurseSameContent b = new PurseSameContent();
	b.addCoin("Nickel");
	b.addCoin("Dime");
	b.addCoin("Dime");
	b.addCoin("Quarter");
	
	System.out.println(a.sameContent(b));
	
	PurseSameContent c = new PurseSameContent();
	
	c.addCoin("Quarter");
	c.addCoin("Penny");
	c.addCoin("Nickel");
	c.addCoin("Dime");
	
	PurseSameContent d = new PurseSameContent();
	d.addCoin("Nickel");
	d.addCoin("Dime");
	d.addCoin("Dime");
	d.addCoin("Quarter");
	
	System.out.println(c.sameContent(d));
	/*
	String[] name = {"Quarter", "Dime", "Nickel", "Dime"};
	calc.addCoin(name);
	*/
	/*
	System.out.println(a.toString());
	System.out.println(b.toString());
	System.out.println(a.reverse());
	System.out.println(b.reverse());
	*/
	}
}