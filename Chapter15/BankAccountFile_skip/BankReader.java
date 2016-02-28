//Chapter 15 - Exercise 15.8

import java.util.Scanner;
import java.io.IOException;

/**
   This program prompts the user to enter a file name
   with account information. A bank object is filled with
   the account numbers and balances specified in the file. 
   In case of an exception, the user can choose another file.
*/
public class BankReader
{
   public static void main(String[] args)
   {
      boolean done = false;
      Scanner in = new Scanner(System.in);
      
      while (!done)
      {
         System.out.print("Filename: ");
         String filename = in.next();

         try
         {
            Bank bank = new Bank();
            bank.readFile(filename);
            BankAccount highest = bank.getHighestBalance();
            System.out.println(highest.getAccountNumber()
                  + " " + highest.getBalance());
            done = true;
         }   
         catch (IOException e)
         {   
            e.printStackTrace();    
         }
      }
   }
}