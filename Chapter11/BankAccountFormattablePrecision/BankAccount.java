//Chapter11 - Exercise P11.18

import java.io.IOException;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Scanner;

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

    public void formatTo(Formatter formatter, int flags, int width, int precision) 
	{
        Appendable a = formatter.out();
        
        double rounded = Math.round(balance * Math.pow(10, precision)) / Math.pow(10, precision);// round appropriately based on precision
        String balanceString = Double.toString(rounded);
    
        Scanner getDecimal = new Scanner(balanceString); // add trailing 0s if necessary
        getDecimal.useDelimiter("\\.");
        String digitsPart = getDecimal.next();
        String decimalPart = getDecimal.next();
        getDecimal.close();
       
	   if (precision == 0) 
		{
            balanceString = digitsPart;  // remove any decimal part if the precision is 0
		} 
	   else 
		{
            int extraZeros = decimalPart.length();// add remaining extra zeros
            
			while (extraZeros < precision) 
			{
                balanceString = balanceString + "0";
                extraZeros++;
            }
        }
       
	   while (width > balanceString.length()) 
		{
            balanceString = " " + balanceString;
		}
        
		try 
			{
            a.append(balanceString);
			} 
		catch (IOException e) 
			{
            System.out.println("Error!");
			}
    }
}