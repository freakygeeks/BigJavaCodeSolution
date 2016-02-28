//Chapter3 - Example 3.5
public class BankAccountThisTester
{
	public static void main (String[] args)
	{
	BankAccountThis check = new BankAccountThis();
	check.deposit(500);
	check.withdraw(200);
	
	double checking = check.getBalance();
	
	System.out.println (checking);
	}
}