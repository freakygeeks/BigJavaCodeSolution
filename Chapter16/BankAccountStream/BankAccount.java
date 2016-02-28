//Chapter 16 - Example 16.5

import java.io.Serializable;

public class BankAccount implements Serializable
{
	private int accountNumber;
	private double balance;

	public BankAccount(int anAccountNumber) 
	{
	accountNumber = anAccountNumber;
	balance = 0;
	}
	
	public BankAccount(int anAccountNumber, double initialBalance)
	{
	accountNumber = anAccountNumber;
	balance = initialBalance;
	}
	
	public int getAccountNumber()
	{
	return accountNumber;
	}
	
	public void deposit(double amount)
	{
	double newBalance = balance + amount;
	balance = newBalance;
	}
	
	public void withdraw(double amount)
	{
	double newBalance = balance - amount;
	balance = newBalance;
	}
	
	public double getBalance()
	{
	return balance;
	}
}