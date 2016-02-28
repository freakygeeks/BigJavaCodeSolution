//Chapter 13 - Example 13.6

public class AccountTester
{
	public static void main (String[] args)
	{
		SavingAccount momSaving = new SavingAccount(0.5);
		CheckingAccount harryChecking = new CheckingAccount(100);
		
		momSaving.deposit(10000);
		momSaving.transfer(2000, harryChecking);
		harryChecking.withdraw(1500);
		harryChecking.withdraw(80);
		
		momSaving.transfer(1000, harryChecking);
		harryChecking.withdraw(400);
		
		momSaving.addInterest();
		harryChecking.deductFee();
		
		System.out.println ("Mom saving balance = $" + momSaving.getBalance());
		System.out.println ("Harry checking balance = $" + harryChecking.getBalance());
	}
}