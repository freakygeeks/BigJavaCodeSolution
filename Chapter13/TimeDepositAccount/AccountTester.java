//Chapter 13 - Exercise 13.2

public class AccountTester
{
	public static void main (String[] args)
	{
		SavingAccount mom = new SavingAccount(0.5);
		TimeDepositAccount college = new TimeDepositAccount(1.0, 10000.0, 3, 0.5);
		CheckingAccount harry = new CheckingAccount();
		
		mom.deposit(10000);
		mom.transfer(2000, harry);
				
		harry.withdraw(200);
		harry.withdraw(300);
		harry.withdraw(80);
		harry.withdraw(400);
		
		endOfMonth(mom);
		endOfMonth(mom);
		endOfMonth(mom);
		endOfMonth(college);
		endOfMonth(harry);
		
		college.transfer(980, harry);
				
		System.out.println ("Mom saving : " + mom); //(10000-2000)*0.5%interest = 8040
		System.out.println ("College fund : " + college); //(10000*1%interest)*0.5%penalty-980 =9069.50
		System.out.println ("Harry checking : " + harry); //2000-200-300-80-400-2 count.fee+980 = 1999
	}
	
	public static void endOfMonth (SavingAccount savings) //add interest for a month for SavingAccount
		{
			savings.addInterest();
		}
		
		public static void endOfMonth (CheckingAccount checking) //deduct fee for more than 3 time count in a month using CheckingAccount
		{
			checking.deductFee();
		}
}