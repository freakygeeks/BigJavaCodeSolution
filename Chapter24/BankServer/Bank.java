//Chapter 24 - Example 24.4

public class Bank
{
	private BankAccount[] accounts;
	
	public Bank (int size)
	{
		accounts = new BankAccount[size];
		for (int i = 0; i < accounts.length; i++)
		{
			accounts[i] = new BankAccount();
		}
	}
	
	//deposit money into bank account array
	public void deposit (int accountNumber, double amount)
	{
		BankAccount account = accounts[accountNumber];
		account.deposit(amount);
	}
	
	//withdraw money from bank account array
	public void withdraw (int accountNumber, double amount)
	{
		BankAccount account = accounts[accountNumber];
		account.withdraw(amount);
	}
	
	//return balance from bank account array
	public double getBalance (int accountNumber)
	{
		BankAccount account = accounts[accountNumber];
		return account.getBalance();
	}
}