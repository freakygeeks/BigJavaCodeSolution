//Chapter8 - Exercise P8.4

public class PurseTransferTester
{
	public static void main (String[] args)
	{
	PurseTransfer a = new PurseTransfer();
	
	a.addCoin("Quarter");
	a.addCoin("Dime");
	a.addCoin("Nickel");
	a.addCoin("Dime");
	
	PurseTransfer b = new PurseTransfer();
	b.addCoin("Dime");
	b.addCoin("Nickel");
		
	/*
	String[] name = {"Quarter", "Dime", "Nickel", "Dime"};
	calc.addCoin(name);
	*/
	a.transfer(b);
	System.out.println(a.toString());
	System.out.println(b.toString());
	System.out.println(a.reverse());
	System.out.println(b.reverse());
	}
}