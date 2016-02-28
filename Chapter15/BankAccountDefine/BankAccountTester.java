//Chapter 15 - Exercise 15.2

public class BankAccountTester
{
	public static void main (String[] agrs)
	{
		BankAccount harryChecking = new BankAccount();
		
		try
		{
			harryChecking = new BankAccount (1000); //-1000
			harryChecking.deposit(200); //-200
			harryChecking.withdraw(300); //30000
		}
		
		catch (BadDataException exception)
		{
			System.out.println ("Bad data " + exception.getMessage());
		}

		System.out.println (harryChecking.getBalance());
	}
}