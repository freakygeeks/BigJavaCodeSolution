//Chapter8 - Exercise P8.2

public class PurseTester
{
	public static void main (String[] args)
	{
	Purse calc = new Purse();
	/*
	calc.addCoin("Quarter");
	calc.addCoin("Dime");
	calc.addCoin("Nickel");
	calc.addCoin("Dime");
	*/
	String[] name = {"Quarter", "Dime", "Nickel", "Dime"};
	calc.addCoin(name);
	
	System.out.println(calc.toString());
	}
}