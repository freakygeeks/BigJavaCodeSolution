//Chapter6 - Exercise P6.15

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BankAccountTester
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	GregorianCalendar cal = new GregorianCalendar();
	cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
	cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
	cal.set(Calendar.DAY_OF_MONTH, 30);	
	
	System.out.print ("Enter money to deposit : ");
	int money1 = in.nextInt();
	//int money2 = in.nextInt();
	//int money3 = in.nextInt();
	
	System.out.print ("Enter money to withdraw : ");
	int money4 = in.nextInt();
	//int money5 = in.nextInt();
	//int money6 = in.nextInt();
	
	BankAccount calc = new BankAccount();
	calc.getDeposit(money1);
	//calc.getDeposit(money2);
	//calc.getDeposit(money3);
	calc.getWithdraw(money4);
	//calc.getWithdraw(money5);
	//calc.getWithdraw(money6);
	
	if (money1 < 0)
		System.out.println ("Invalid input for deposit");
	else if (money4 < 0)
		System.out.println ("Invalid input for withdraw");
	else if (calc.getAmount() < 0)
		System.out.println ("Rejecting withdrawal exceeding saving amount");
	else
	{	
	System.out.println ("Your balance is " + calc.getAmount() + ". Your exceeding transaction is " + calc.getNum() + " times");
	
	return;
	}
	}
}