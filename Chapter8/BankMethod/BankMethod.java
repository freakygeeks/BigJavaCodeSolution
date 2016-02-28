//Chapter8 - Exercise P8.1

import java.util.ArrayList;

public class BankMethod
{
	private ArrayList<BankAccountMethod> accounts;
	
	public BankMethod()
	{
	accounts = new ArrayList<BankAccountMethod>();
	}
	
	public void addAccount(BankAccountMethod a)//to add bank account number
	{
	accounts.add(a);
	}
	
	public double getTotalBalance()//to get total balance
	{
	double total = 0;
	
	for(BankAccountMethod a : accounts)
		{
		total = total + a.getBalance();//call getBalance method in BankAccountMethod
		}
	return total;
	}
	
	public int count(double atLeast)//to calculate bank account match with the value given in main
	{
	int matches = 0;
	
	for(BankAccountMethod a : accounts)
		{
		if(a.getBalance() >= atLeast)//compare all balance in array with atLeast value
			matches++;
		}
	return matches;
	}
	
	public BankAccountMethod find(int accountNumber)//to find the account number given in main
	{
	for(BankAccountMethod a : accounts)
		{
		if(a.getAccountNumber() == accountNumber) //compare all accoun number in array with accountNumber
		return a;
		}
	return null;
	}
	
	public BankAccountMethod getMaximum()//to get max balance in array
	{
	if(accounts.size() == 0)
		return null;
		
	BankAccountMethod largestYet = accounts.get(0);//initial largestYet value to point to the 1st array element
	for(int i = 1; i < accounts.size(); i++)
		{
		BankAccountMethod a = accounts.get(i);
		if(a.getBalance() > largestYet.getBalance())//compare all balance in array with largestYet
			largestYet = a;
		}
	return largestYet;
	}
	
	public BankAccountMethod getMinimum()//to get max balance in array
	{
	if(accounts.size() == 0)
		return null;
		
	BankAccountMethod smallestYet = accounts.get(0);//initial smallestYet value to point to the 1st array element
	for(int i = 1; i < accounts.size(); i++)
		{
		BankAccountMethod a = accounts.get(i);
		if(a.getBalance() < smallestYet.getBalance())//compare all balance in array with smallestYet
			smallestYet = a;
		}
	return smallestYet;
	}
}