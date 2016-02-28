//Chapter 21 - Exercise 21.7

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BankAccountTester
{
	public static void main (String[] args)
	{
		BankAccount acc1 = new BankAccount(10000);
		BankAccount acc2 = new BankAccount(3400);
		BankAccount acc3 = new BankAccount(100);
		BankAccount acc4 = new BankAccount(98000);
		
		System.out.println("hash code of acc1 = " + acc1.hashCode());
		System.out.println("hash code of acc2 = " + acc2.hashCode());
		System.out.println("hash code of acc3 = " + acc3.hashCode());
		System.out.println("hash code of acc4 = " + acc4.hashCode());
		
		Set accounts = new HashSet();
		
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		accounts.add(acc4);
		
		Iterator iter = accounts.iterator();
		
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
}










