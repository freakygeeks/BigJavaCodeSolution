//Chapter3 - Project 3.1
import java.util.GregorianCalendar;
import java.util.Calendar;

public class BankAccountProject //https://gist.github.com/anonymous/10584308, http://stackoverflow.com/questions/14044316/using-math-max-for-a-bankaccount-class
{
	private double amount;
	private double fee;
	private int num;
	private int numLimit;
	
	public BankAccountProject()
	{
	amount = 0;
	fee = 1;
	num = 0;
	numLimit = 3;

	}
	
	public void deposit (double money)
	{
	num++;
	this.amount = this.amount + money;

	/*numA++;
	if(numA<=numLimitA)
		{
		this.amount = this.amount + money;
		}
		else
		{
		this.amount = this.amount + money - this.feeA;
		this.feeA = this.feeA;
		}*/
		
	}
	
	public void withdraw (double money)
	{
	num++;
	this.amount = this.amount - money;

	/*numB++;
	if(numB<=numLimitB)
		{
		this.amount = this.amount - money;
		}
		else
		{
		this.amount = this.amount - money - this.feeB;
		}*/
		
	}
	
	public void deductMontlyCharge(GregorianCalendar endMonth)
	{
	GregorianCalendar today = new GregorianCalendar();
	if(today.after(endMonth))
		{
		this.num = this.num - this.numLimit;
		this.amount = this.amount - this.num;
		}
	else
		{
		this.amount = this.amount;
		}
	}
	
	public void reset ()
	{
	num = 0;
	}
	
	public double getAmount()
	{
	return this.amount ;
	}
	
	public double getNum()
	{
	return this.num;
	}
	
}