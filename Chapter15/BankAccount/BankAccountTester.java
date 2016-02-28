//Chapter 15 - Exercise 15.1

public class BankAccountTester
{
	public static void main (String[] agrs)
	{
		BankAccount harryChecking = new BankAccount();
		try
		{
			harryChecking = new BankAccount(-500);
			harryChecking.deposit(-100);
			harryChecking.withdraw(20000);
		}
		
		catch (IllegalArgumentException exception)
		{
			harryChecking = new BankAccount(1000); //-1000
			harryChecking.deposit(200); //-200
			harryChecking.withdraw(300);//30000
		}
		
		System.out.println (harryChecking.getBalance());
	}
}