//Chapter 23 - Example 23.3

public class BankAccount
{
	private double balance;
	
	public BankAccount()
	{
		balance = 0;
	}
	
	//deposit money
	public void deposit(double amount)
	{
		System.out.print("Depositing " + amount);
		double newBalance = balance + amount;
		System.out.println(", new balance is " + newBalance);
		balance = newBalance;
	}
	
	//withdraw money
	public void withdraw(double amount)
	{
		System.out.print("Withdrawing " + amount);
		double newBalance = balance - amount;
		System.out.println(", new balance is " + newBalance);
		balance = newBalance;
	}
	
	public double getBalance()
	{
		return balance;
	}
}