//Chapter7 - Example 7.2

public class InvestmentForLoopTester
{
	public static void main (String[] args)
	{
	final double INITIAL_BALANCE = 10000;
	final double RATE = 5;
	final int YEARS = 20;
	
	InvestmentForLoop calc = new InvestmentForLoop (INITIAL_BALANCE, RATE);
	calc.waitYears(YEARS);
	double balance = calc.getBalance();
	
	System.out.printf ("The balance after %d years is %.2f\n", YEARS, balance);
	//%d = placeholder of variable "d" to be substitute with YEARS
	//%.2f = placeholder of variable "f" of decimal number should be printed to two decimal places 
	//\n = newline
	//System.out.printf ("The balance after " + YEARS + " is " + balance);
	}
}