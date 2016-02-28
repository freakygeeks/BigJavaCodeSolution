//Chapter8 - Exercise P8.3

public class PurseReverseTester
{
	public static void main (String[] args)
	{
	PurseReverse calc = new PurseReverse();
	/*
	calc.addCoin("Quarter");
	calc.addCoin("Dime");
	calc.addCoin("Nickel");
	calc.addCoin("Dime");
	*/
	String[] name = {"Quarter", "Dime", "Nickel", "Dime"};
	calc.addCoin(name);
	
	System.out.println(calc.toString());
	System.out.println(calc.reverse());
	}
}