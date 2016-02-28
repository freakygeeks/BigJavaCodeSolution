//Chapter3 - Example 3.5
/*This a class to test and execute method in the BankAccount class*/
public class BankAccountTester
{
	/*To test the method of BankAccount class*/
	public static void main (String[] args)
	{
	/*create the constructor "BankAccount" */
	BankAccount harryChecking = new BankAccount();
	/*invoked the method "deposit" */
	harryChecking.deposit (2000);
	/*invoked the method "withdraw" */
	harryChecking.withdraw (500);
	/*invoked the method "getBalance" */
	System.out.println(harryChecking.getBalance());
	}
}