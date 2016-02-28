//Chapter 16 - Example 16.5

import java.util.ArrayList;
import java.io.Serializable;

public class Bank implements Serializable
{
	
	private ArrayList<BankAccount> accounts;
	
	public Bank()
	{
	accounts = new ArrayList<BankAccount>();
	}
	
	public void addAccount(BankAccount a)//to add bank account number
	{
	accounts.add(a);
	}
	
	public double getTotalBalance()//to get total balance
	{
	double total = 0;
	
	for(BankAccount a : accounts)
		{
		total = total + a.getBalance();//call getBalance method in BankAccount
		}
	return total;
	}
	
	public int count(double atLeast)//to calculate bank account match with the value given in main
	{
	int matches = 0;
	
	for(BankAccount a : accounts)
		{
		if(a.getBalance() >= atLeast)//compare all balance in array with atLeast value
			matches++;
		}
	return matches;
	}
	
	public BankAccount find(int accountNumber)//to find the account number given in main
	{
	for(BankAccount a : accounts)
		{
		if(a.getAccountNumber() == accountNumber) //compare all accoun number in array with accountNumber
		return a;
		}
	return null;
	}
	
	public BankAccount getMaximum()//to get max balance in array
	{
	if(accounts.size() == 0)
		return null;
		
	BankAccount largestYet = accounts.get(0);//initial largestYet value to point to the 1st array element
	for(int i = 1; i < accounts.size(); i++)
		{
		BankAccount a = accounts.get(i);
		if(a.getBalance() > largestYet.getBalance())//compare all balance in array with largestYet
			largestYet = a;
		}
	return largestYet;
	}
	
	public BankAccount getMinimum()//to get max balance in array
	{
	if(accounts.size() == 0)
		return null;
		
	BankAccount smallestYet = accounts.get(0);//initial smallestYet value to point to the 1st array element
	for(int i = 1; i < accounts.size(); i++)
		{
		BankAccount a = accounts.get(i);
		if(a.getBalance() < smallestYet.getBalance())//compare all balance in array with smallestYet
			smallestYet = a;
		}
	return smallestYet;
	}
}