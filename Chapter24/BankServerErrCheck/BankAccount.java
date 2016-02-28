//Chapter 24 - Exercise 24.4

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount
{
   private double balance;
   private Lock balanceChangeLock;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {   
      balance = 0;
      balanceChangeLock = new ReentrantLock();
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance)
   {   
	  balance = initialBalance;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount) throws InsufficientFundsException
   {  
      balanceChangeLock.lock();
      try
      {
         if (amount < 0) throw new InsufficientFundsException ("Error 300 - Amount is negative");
		  
         double newBalance = balance + amount;
         balance = newBalance;
      }
      finally
      {
         balanceChangeLock.unlock();
      }
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount) throws InsufficientFundsException
   {   
      balanceChangeLock.lock();
      try
      {
		 if (amount < 0 || amount > balance) throw new InsufficientFundsException ("Error 300 - Amount is negative");
		  
         double newBalance = balance - amount;
         balance = newBalance;
      }
      finally
      {
         balanceChangeLock.unlock();
      }
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance() throws InsufficientFundsException
   {   
   	  if (balance < 0) throw new InsufficientFundsException ("Error 300 - Balance is negative");
      return balance;
   }

}