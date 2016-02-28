//Chapter 17 - Example 17.5

public class BankAccount
{  
   private double balance; 
   private int accountNumber;

   public BankAccount()
   {  
      accountNumber = 0;
      balance = 0;
   }

   public BankAccount(int anAccountNumber, double initialBalance)
   {  
      accountNumber = anAccountNumber;
      balance = initialBalance;
   }
   
   public void deposit(double amount) 
   {  
      balance = balance + amount;
   }

   public void withdraw(double amount) 
   {  
      balance = balance - amount;
   }

   public double getBalance()
   {  
      return balance; 
   }
   
   public int getAccountNumber()
   {
      return accountNumber;
   }
}