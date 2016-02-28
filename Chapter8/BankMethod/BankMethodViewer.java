//Chapter8 - Exercise P8.1

public class BankMethodViewer
{
	public static void main (String[] args)
	{
	BankMethod firstBankOfJava = new BankMethod();
	firstBankOfJava.addAccount(new BankAccountMethod(1001, 20000));//call addAccount method in BankMethod.java
	firstBankOfJava.addAccount(new BankAccountMethod(1015, 10000));//call addAccount method in BankMethod.java
	firstBankOfJava.addAccount(new BankAccountMethod(1729, 15000));//call addAccount method in BankMethod.java
	
	double threshold = 15000;
	int c = firstBankOfJava.count(threshold);//call count method in BankMethod.java
	System.out.println(c + " accounts with balance >= " + threshold);
	
	int accountNumber = 1015;
	BankAccountMethod a = firstBankOfJava.find(accountNumber);//call find method in BankMethod.java
	if(a == null)
		{
		System.out.println("No account with number " + accountNumber);
		}
	else
		{
		System.out.println("Account with number " + accountNumber + " has balance " + a.getBalance());
		}
		
	BankAccountMethod max = firstBankOfJava.getMaximum();//call maximum method in BankMethod.java
	System.out.println("Account with number " + max.getAccountNumber() + " has the largest balance");		
	
	BankAccountMethod min = firstBankOfJava.getMinimum();//call minimum method in BankMethod.java
	System.out.println("Account with number " + min.getAccountNumber() + " has the smallest balance");	
	}
}