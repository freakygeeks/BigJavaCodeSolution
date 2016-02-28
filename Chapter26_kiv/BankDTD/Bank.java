//Chapter 26 - Exercise 26.5

import java.util.ArrayList;

public class Bank
{
	private ArrayList accounts;
	
	public Bank()
	{
		accounts = new ArrayList();
	}
	
	public void createAccount(BankAccount ba)
	{
		accounts.add(ba);
	}
	
	public double getTotalBalance()
	{
		double total = 0.0;
		
		for (int i = 0; i < accounts.size(); i++)
		{
			total = total + ((BankAccount)accounts.get(i)).getBalance();
		}
		
		return total;
	}
}