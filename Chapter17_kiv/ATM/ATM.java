//Chapter 17 - Example 17.5

import java.io.IOException;

public class ATM
{
	private int state;
	private int customerNumber;
	private Customer currentCustomer;
	private BankAccount currentAccount;
	private Bank theBank;
	
	public static final int START = 1;
	public static final int PIN = 2;
	public static final int ACCOUNT = 3;
	public static final int TRANSACT = 4;
	
	public static final int CHECKING = 1;
	public static final int SAVINGS = 2;
	
	public ATM (Bank aBank)
	{
		theBank = aBank;
		reset();
	}
	
	
	//reset ATM
	public void reset()
	{
		customerNumber = -1;
		currentAccount = null;
		state = START;
	}
	
	//set customer number and pin
	public void setCustomerNumber (int number)
	{
		assert state == START;
		customerNumber = number;
		state = PIN;
	}
	
	//find customer in bank
	public void selectCustomer (int pin)
	{
		assert state == PIN;
		currentCustomer = theBank.findCustomer(customerNumber, pin);
		
		if (currentCustomer == null)
		{
			state = START;
		}
		
		else
		{
			state = ACCOUNT;
		}
	}
	
	//set account to checking or saving
	public void selectAccount(int account)
	{
		assert state == ACCOUNT || state == TRANSACT;
		
		if (account == CHECKING)
		{
			currentAccount = currentCustomer.getCheckingAccount();
		}
		
		else
		{
			currentAccount = currentCustomer.getSavingsAccount();
		}
		
		state = TRANSACT;
	}
	
	//withdraw amount from account
	public void withdraw(double value)
	{
		assert state == TRANSACT;
		currentAccount.withdraw(value);
	}
	
	//deposit amount from account
	public void deposit(double value)
	{
		assert state == TRANSACT;
		currentAccount.deposit(value);
	}
	
	//getbalance of account
	public double getBalance()
	{
		assert state == TRANSACT;
		return currentAccount.getBalance();
	}
	
	//move back to previous state
	public void back()
	{
		if (state == TRANSACT)
		{
			state = ACCOUNT;
		}
		
		else if (state == ACCOUNT)
		{
			state = PIN;
		}
		
		else if (state == PIN)
		{
			state = START;
		}
	}
	
	//get current state of ATM
	public int getState()
	{
		return state;
	}
}
































