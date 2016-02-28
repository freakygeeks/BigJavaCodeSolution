//Chapter 13 - Project 13.2

public class AccountTester
{
	public static void main (String[] args) throws CloneNotSupportedException
	{
		SavingAccount momSaving = new SavingAccount(100);
		CheckingAccount harryChecking = new CheckingAccount(100);
		
		momSaving.deposit(10000);
		momSaving.transfer(2000, harryChecking);
		harryChecking.withdraw(1500);
		harryChecking.withdraw(80);
		momSaving.transfer(1000, harryChecking);
		harryChecking.withdraw(400);
		
		momSaving.addInterest();
		harryChecking.deductFee();
		
		SavingAccount momClone = (SavingAccount) momSaving.clone();
		CheckingAccount harryClone = (CheckingAccount) harryChecking.clone();

		System.out.println("Mom Saving memory not same Mom Clone : " + (momSaving != momClone));
		System.out.println("Mom Saving class same Mom Clone : " + (momSaving.getClass() == momClone.getClass()));
		System.out.println("Mom Saving objects reference equals Mom Clone : " + momSaving.equals(momClone));
		System.out.println("Mom Saving : " + momSaving.toString());
		System.out.println("Mom Clone : " + momClone.toString() + "\n");

		System.out.println("Harry Checking memory not same Harry Clone : " + (harryChecking != harryClone));
		System.out.println("Harry Checking class same Harry Clone : " + (harryChecking.getClass() == harryClone.getClass()));
		System.out.println("Harry Checking objects reference equals Harry Clone : " + harryChecking.equals(harryClone));
		System.out.println("Harry Checking : " + harryChecking.toString());
		System.out.println("Harry Clone : " + harryClone.toString()); 
	}
}