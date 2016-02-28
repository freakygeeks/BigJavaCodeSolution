//Chapter 16 - Example 16.4

import java.io.IOException;
import java.io.RandomAccessFile;

public class BankData
{
	private RandomAccessFile file;
	public static final int INT = 4;
	public static final int DOUBLE = 8;
	public static final int RECORD = INT + DOUBLE;
	
	public BankData()
	{
		file = null;
	}
	
	public void open (String filename) throws IOException
	{
		if (file != null) 
		{
			file.close();
		}
		
		file = new RandomAccessFile(filename, "rw");
	}
	
	public int size() throws IOException
	{
		return (int) (file.length()/RECORD);
	}
	
	public void close() throws IOException
	{
		if (file != null)
		{
			file.close();
		}
		
		file = null;
	}
	
	public BankAccount read (int n) throws IOException
	{
		file.seek(n*RECORD);
		int accountNumber = file.readInt();
		double balance = file.readDouble();
		
		return new BankAccount(accountNumber, balance);
	}	
	
	public int find (int accountNumber) throws IOException
	{
		for (int i = 0; i < size(); i++)
		{
			file.seek(i*RECORD);
			int a = file.readInt();
			if (a == accountNumber)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public void write (int n, BankAccount account) throws IOException
	{
		file.seek(n*RECORD);
		file.writeInt(account.getAccountNumber());
		file.writeDouble(account.getBalance());
	}
}






















































