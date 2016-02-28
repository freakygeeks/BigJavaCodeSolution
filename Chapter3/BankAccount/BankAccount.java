//Chapter3 - Example 3.5
/*A bank account has a balance that can be changed by deposit and withdrawals
- This implementation of class can be compile but cannot be execute because
there is no main method.
- Most classes don't contain a main method.
- Way to execute is by writing another class with main method which invoke this class method
and execute it*/

public class BankAccount
{
	private double balance;
	/*constructs a bank account with a zero balance*/
	public BankAccount()
	{
	balance = 0;
	}
	/*constructs a bank account with a given balance
	parameter is "initialBalance"*/
	public BankAccount (double initialBalance)
	{
	balance = initialBalance;
	}
	/*deposit money into the bank account
	parameter is "amount"*/
	public void deposit (double amount)//mutator
	{
	double newBalance = balance + amount;
	balance = newBalance;
	}
	/*withdraw money from the bank account
	parameter is "amount"*/
	public void withdraw (double amount)//mutator
	{
	double newBalance = balance - amount;
	balance = newBalance;
	}
	/*get the current balance of the bank account
	parameter statement is "return"*/
	public double getBalance()//asessor
	{
	return balance;
	}
}