//Chapter3 - Project 3.1
import java.util.GregorianCalendar;
import java.util.Calendar;

public class BankAccountProjectTester
{
	public static void main (String[] args)
	{
	GregorianCalendar date = new GregorianCalendar();
	date.set(Calendar.YEAR, date.get(Calendar.YEAR));
	date.set(Calendar.MONTH, date.get(Calendar.MONTH));
	date.set(Calendar.DAY_OF_MONTH, 30);
		
	BankAccountProject amount = new BankAccountProject();
	amount.deposit(1000);
	amount.deposit(50);
	amount.deposit(50);
	amount.deposit(50);
	amount.deposit(50);
	amount.deposit(50);
	amount.withdraw(50);
	amount.withdraw(50);
	amount.withdraw(50);
	amount.withdraw(50);
	amount.deductMontlyCharge(date);
	
	double total = amount.getAmount();
	
	System.out.println ("Your balance is : RM " + total + ". Your exceeding transaction is : " + amount.getNum() + " times");
	
	amount.reset();
	}
}