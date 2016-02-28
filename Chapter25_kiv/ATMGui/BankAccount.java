//Chapter 25 - Example 25.5

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount
{  
   /**
      Constructs a bank account with a given balance.
      @param anAccountNumber the account number
   */
   public BankAccount(int anAccountNumber)
   {  
      accountNumber = anAccountNumber;
   }

   /**
      Deposits money into a bank account.
      @param accountNumber the account number
      @param amount the amount to deposit
   */
   public void deposit(double amount)
         throws SQLException
   {
      Connection conn = SimpleDataSource.getConnection();
      try
      {
         PreparedStatement stat = conn.prepareStatement(
               "UPDATE Account"
               + " SET Balance = Balance + ?"
               + " WHERE Account_Number = ?");
         stat.setDouble(1, amount);
         stat.setInt(2, accountNumber);
         stat.executeUpdate();      
      }
      finally
      {
         conn.close();
      }
   }

   /**
      Withdraws money from a bank account.
      @param accountNumber the account number
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
         throws SQLException
   {
      Connection conn = SimpleDataSource.getConnection();
      try
      {
         PreparedStatement stat = conn.prepareStatement(
               "UPDATE Account"
               + " SET Balance = Balance - ?"
               + " WHERE Account_Number = ?");
         stat.setDouble(1, amount);
         stat.setInt(2, accountNumber);
         stat.executeUpdate();      
      }
      finally
      {
         conn.close();
      }
   }

   /**
      Gets the balance of a bank account.
      @param accountNumber the account number
      @return the account balance
   */
   public double getBalance()
         throws SQLException
   {
      Connection conn = SimpleDataSource.getConnection();
      try
      {
         double balance = 0;
         PreparedStatement stat = conn.prepareStatement(
               "SELECT Balance FROM Account WHERE Account_Number = ?");
         stat.setInt(1, accountNumber);
         ResultSet result = stat.executeQuery();
         if (result.next())
            balance = result.getDouble(1);
         return balance;
      }
      finally
      {
         conn.close();
      }
   }

   private int accountNumber;
}

