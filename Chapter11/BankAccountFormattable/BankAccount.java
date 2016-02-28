//Chapter11 - Exercise P11.17

import java.util.Formattable;
import java.util.Formatter;
import java.io.IOException;

public class BankAccount implements Formattable
{
	private double balance;

   public BankAccount()
   {
      balance = 0;
   }

   public BankAccount(double initialBalance)
   {
      balance = initialBalance;
   }

   public void deposit(double amount)
   {
      double newBalance = balance + amount;
      balance = newBalance;
   }

   public void withdraw(double amount)
   {
      double newBalance = balance - amount;
      balance = newBalance;
   }

   public double getBalance()
   {
      return balance;
   }
   
   public void formatTo (Formatter formatter, int flags, int width, int precision)
   {
		Appendable a = formatter.out();
		String balanceString = Double.toString(balance);
		
		while (width > balanceString.length()) 
		{
            balanceString = " " + balanceString;
        }
		
		try {
            a.append(balanceString);
        } catch (IOException e) {
            System.out.println("Error!");
        }
   }
}

