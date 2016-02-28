//Chapter6 - Project P6.2

import java.util.Scanner;

public class TaxScheduleViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Single = S, Married Filled Jointly = MJ, Married Filled Separately = MS, Head of Household = H ");
	System.out.print ("Please enter your tax categories using above code : ");
	String input1 = in.nextLine();
	
	int stat = 0;
	{
	if (input1.equalsIgnoreCase("S"))
		stat = TaxSchedule.S;
	else if (input1.equalsIgnoreCase("MJ"))
		stat = TaxSchedule.MJ;
	else if (input1.equalsIgnoreCase("MS"))
		stat = TaxSchedule.MS;
	else if (input1.equalsIgnoreCase("H"))
		stat = TaxSchedule.H;
	else
		{
		System.out.println ("Bad input!");
		return;
		}
	}
	
	System.out.print ("Please enter your income : ");
	double income = in.nextDouble();
	
	TaxSchedule calc = new TaxSchedule (stat , income);
	
	double a = 0;
	{
	if (income >= 25200 && income <= 25400)
		a = income;
	else 
		{
		System.out.println ("Value of income enter is not valid");
		return;
		}
	}
	
	System.out.println ("Your tax is : " + calc.getTax());
	}
}