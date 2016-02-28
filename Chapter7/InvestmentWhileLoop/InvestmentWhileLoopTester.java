//Chapter7 - Example 7.1

public class InvestmentWhileLoopTester
{
	public static void main (String[] args)
	{
	final double INITIAL_BALANCE = 10000;
	final double RATE = 5;
	
	InvestmentWhileLoop calc = new InvestmentWhileLoop (INITIAL_BALANCE, RATE);
	//calc.waitForBalance(2*INITIAL_BALANCE);
	calc.waitForBalance();
	int years = calc.getYears();
	double balance = calc.getBalance();
	
	System.out.println ("The investment doubled after " + years + " years with balance of " + balance);
	}
}