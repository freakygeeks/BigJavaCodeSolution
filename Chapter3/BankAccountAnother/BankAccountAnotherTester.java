//Chapter3 - Exercise P3.1
public class BankAccountAnotherTester
{
	public static void main (String[] args)
	{
	BankAccountAnother balance = new BankAccountAnother();
	balance.deposit(1000);
	balance.withdraw(500);
	balance.withdraw(400);
	
	double newBalance = balance.getBalance();
	
	System.out.println (newBalance);
	}
}