//Chapter 16 - Example 16.5

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BankAccountStreamTester
{
	public static void main (String[] args) throws IOException, ClassNotFoundException
	{
		Bank firstBankOfJava;
		
		File f = new File("bank.txt");
		
		if(f.exists())
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			firstBankOfJava = (Bank) in.readObject();
			in.close();
		}
		
		else
		{
			firstBankOfJava = new Bank();
			firstBankOfJava.addAccount(new BankAccount(1001, 20000));
			firstBankOfJava.addAccount(new BankAccount(1015, 10000));
		}
		
		//deposit some money
		BankAccount a = firstBankOfJava.find(1001);
		a.deposit(100);
		System.out.println(a.getAccountNumber() + ":" + a.getBalance());
		
		BankAccount b = firstBankOfJava.find(1015);
		//b = firstBankOfJava.find(1015);
		System.out.println(b.getAccountNumber() + ":" + b.getBalance());
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(firstBankOfJava);
		out.close();
	}
}




























