//Chapter 13 - Exercise 13.1

public class AccountTester
{
	public static void main (String[] args)
	{
		SavingAccount momSaving = new SavingAccount(0.5);
		
		momSaving.deposit(10000);
		momSaving.addInterest();
		momSaving.withdraw(5000);
		momSaving.withdraw(3000);
		momSaving.deposit(10000);
		momSaving.addInterest();
	
		System.out.println("The balance is $" + momSaving.getBalance());//12010
	}
}