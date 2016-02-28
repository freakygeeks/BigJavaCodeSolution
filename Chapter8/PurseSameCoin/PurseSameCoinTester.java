//Chapter8 - Exercise P8.6

public class PurseSameCoinTester
{
	public static void main (String[] args)
	{
	PurseSameCoin a = new PurseSameCoin();
	
	a.addCoin("Quarter");
	a.addCoin("Dime");
	a.addCoin("Nickel");
	a.addCoin("Dime");
	
	PurseSameCoin b = new PurseSameCoin();
	b.addCoin("Nickel");
	b.addCoin("Dime");
	b.addCoin("Dime");
	b.addCoin("Quarter");
	
	System.out.println(a.sameCoin(b));
	
	PurseSameCoin c = new PurseSameCoin();
	
	c.addCoin("Quarter1");
	c.addCoin("Penny1");
	c.addCoin("Nickel1");
	c.addCoin("Dime1");
	
	PurseSameCoin d = new PurseSameCoin();
	d.addCoin("Nickel2");
	d.addCoin("Dime2");
	d.addCoin("Dime2");
	d.addCoin("Quarter2");
	
	System.out.println(c.sameCoin(d));
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