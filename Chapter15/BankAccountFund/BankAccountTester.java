//Chapter 15 - Exercise 15.5

public class BankAccountTester
{
	public static void main (String[] agrs)
	{
		BankAccount harryChecking = new BankAccount();
		
		try
		{
			harryChecking = new BankAccount (1000); //-1000
			harryChecking.deposit(200); //-200
			harryChecking.withdraw(3000); //30000
		}
		
		catch (BadDataException exception)
		{
			System.out.println ("Bad data " + exception.getMessage());
		}
		
		catch (InsufficientFundsException exception)
		{
			System.out.println ("Amount is out of range " + exception.getMessage());
		}

		System.out.println (harryChecking.getBalance());
	}
}