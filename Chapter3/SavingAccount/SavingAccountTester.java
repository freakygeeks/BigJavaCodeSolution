//Chapter3 - Exercise P3.3
public class SavingAccountTester
{
	public static void main (String[] args)
	{
	SavingAccount saving = new SavingAccount();
	saving.addInterest();
	saving.addInterest();
	saving.addInterest();
	saving.addInterest();
	saving.addInterest();
	
	double newInterest = saving.getBalance();
	
	System.out.println (newInterest);
	}
}