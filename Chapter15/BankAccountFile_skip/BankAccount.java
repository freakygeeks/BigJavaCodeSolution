//Chapter 15 - Exercise 15.8
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_18

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

/**
   A bank account has a balance that can be changed by deposits and withdrawals.
*/
public class BankAccount
{  
   private double balance; 
   private int accountNumber;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {  
      accountNumber = 0;
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(int anAccountNumber, double initialBalance)
   {  
      accountNumber = anAccountNumber;
      balance = initialBalance;
   }
   
   /**
      Reads an account number and balance.
      @param in the scanner
      @return true if the data was read
      false if the end of the stream was reached
   */
   public void read(Scanner in) throws IOException
   {
		double aBalance = in.nextDouble();
		balance = Double.parseDouble(aBalance);
		
   }   
 
   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount) 
   {  
      balance = balance + amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount) 
   {  
      balance = balance - amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {  
      return balance; 
   }
   
   /**
      Gets the account number of the bank account.
      @return the account number
   */
   public int getAccountNumber()
   {
      return accountNumber;
   }
}