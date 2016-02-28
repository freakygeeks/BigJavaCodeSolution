//Chapter 26 - Exercise 26.5

public class BankTester
{
	public static void main (String[] args) throws Exception
	{
		BankParser parser = new BankParser();
		Bank b = parser.parse("bank.xml");
		System.out.println("Total balance : " + b.getTotalBalance());
	}
}