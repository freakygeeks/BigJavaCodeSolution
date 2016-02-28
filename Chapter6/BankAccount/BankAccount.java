//Chapter6 - Exercise P6.15

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BankAccount
{
	private double amount;
	private double fee;
	private double num;
	private double numLimit;
	
	public BankAccount()
	{
	amount = 0;
	fee = 1;
	num = 0;
	numLimit = 3;
	}
	
	public void getDeposit(double money)
	{
	num++;
	this.amount = this.amount + money;
	}
	
	public void getWithdraw(double money)
	{
	num++;
	this.amount = this.amount - money;
	}
	
	public void deductMontlyCharge(GregorianCalendar endMonth)
	{
	GregorianCalendar today = new GregorianCalendar();
	if (today.after(endMonth))
		{
		this.num = this.num - this.numLimit;
		this.amount = this.amount - this.num;
		}
	else
		{
		this.amount = this.amount;
		}
	}
	
	public void reset()
	{
	num =0;
	}
	
	public double getAmount()
	{
	return this.amount;
	}
	
	public double getNum()
	{
	return this.num;
	}
}