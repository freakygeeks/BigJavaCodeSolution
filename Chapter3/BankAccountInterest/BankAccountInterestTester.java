//Chapter3 - Exercise P3.2
public class BankAccountInterestTester
{
	public static void main (String[] args)
	{
	BankAccountInterest interest = new BankAccountInterest();
	interest.saving(1000);
	interest.addInterest(10);
	
	double newInterest = interest.getBalance();
	
	System.out.println (newInterest);
	}
}