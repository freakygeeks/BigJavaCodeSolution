//Chapter8 - Example 8.2

import java.util.ArrayList;

public class BankAccountViewer
{
	public static void main(String[] args)
	{
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	accounts.add(new BankAccount(1001));
	accounts.add(new BankAccount(1015));
	accounts.add(new BankAccount(1729));
	accounts.add(new BankAccount(1008));
	accounts.remove(0);
	
	System.out.println("Size = " + accounts.size());
	
	BankAccount first = accounts.get(0);
	System.out.println("First account number : " + first.getAccountNumber());
	
	BankAccount last = accounts.get(accounts.size() - 1);
	System.out.println("Last account number : " + last.getAccountNumber());
	}
}