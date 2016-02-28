//Chapter 17 - Example 17.5

public class Customer
{
	private int customerNumber;
	private int pin;
	private BankAccount checkingAccount;
	private BankAccount savingsAccount;
	
	public Customer(int aNumber, int aPin)
	{
		customerNumber = aNumber;
		pin = aPin;
		checkingAccount = new BankAccount();
		savingsAccount = new BankAccount();
	}
	
	public boolean match (int aNumber, int aPin)
	{
		return customerNumber == aNumber && pin == aPin;
	}
	
	public BankAccount getCheckingAccount()
	{
		return checkingAccount;
	}
	
	public BankAccount getSavingsAccount()
	{
		return savingsAccount;
	}
}