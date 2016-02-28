//Chapter 15 - Exercise 15.8
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch11/c11_exp_11_18

import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
   A bank contains account numbers and balances of each customer.
*/
public class Bank
{
   private ArrayList<BankAccount> accountList;

   /**
      Construct a Bank object.
   */
   public Bank()
   {
      accountList = new ArrayList<BankAccount>();
   }

   /**
      Read a file with account numbers and balances and adds the accounts
      to the bank.
      @param filename the name of the file
   */
   public void readFile(String filename) throws IOException
   {
      FileReader reader = new FileReader(filename);
	  Scanner in = new Scanner(reader);
	  
	  BankAccount temp = new BankAccount();
	  
	  while (in.hasNextDouble())
	  {
		  temp.read(in);
	  }
   }

   /**
      Add an account to the bank.
      @param b the BankAccount reference
   */
   public void addAccount(BankAccount b)
   {
      accountList.add(b);
   }
   
   /**
      Gets the account with the highest balance.
      @return the account with the highest balance
   */
   public BankAccount getHighestBalance()
   {
      BankAccount max = accountList.get(0);
      
      for (BankAccount account : accountList)
      {
         if (account.getBalance() > max.getBalance())
            max = account;
      }
         
      return max;
   }   
}