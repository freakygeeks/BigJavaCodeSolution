//Chapter 12 - Exercise 12.6

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInterestListener implements ActionListener
{
	private static final double INTEREST_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;

	final BankAccount account = new BankAccount (INITIAL_BALANCE);
	
	public void actionPerformed (ActionEvent event)
	{
		double interest = account.getBalance()*INTEREST_RATE/100;
		account.deposit(interest);
		
		System.out.println("Balance = " + account.getBalance());
	}

}