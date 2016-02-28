//Chapter8 - Example 8.5

public class BankViewer
{
	public static void main (String[] args)
	{
	Bank firstBankOfJava = new Bank();
	firstBankOfJava.addAccount(new BankAccount(1001, 20000));//call addAccount method in bank.java
	firstBankOfJava.addAccount(new BankAccount(1015, 10000));//call addAccount method in bank.java
	firstBankOfJava.addAccount(new BankAccount(1729, 15000));//call addAccount method in bank.java
	
	double threshold = 15000;
	int c = firstBankOfJava.count(threshold);//call count method in bank.java
	System.out.println(c + " accounts with balance >= " + threshold);
	
	int accountNumber = 1015;
	BankAccount a = firstBankOfJava.find(accountNumber);//call find method in bank.java
	if(a == null)
		{
		System.out.println("No account with number " + accountNumber);
		}
	else
		{
		System.out.println("Account with number " + accountNumber + " has balance " + a.getBalance());
		}
		
	BankAccount max = firstBankOfJava.getMaximum();//call maximum method in bank.java
	System.out.println("Account with number " + max.getAccountNumber() + " has the largest balance");		
	
	BankAccount min = firstBankOfJava.getMinimum();//call minimum method in bank.java
	System.out.println("Account with number " + min.getAccountNumber() + " has the smallest balance");	
	}
}