//Chapter 25 - Exercise 25.3

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.IOException;

public class BankData
{
	private Connection conn;
	private Statement stat = null;
	private String queryString;
	public static final int DOUBLE_SIZE = 8;
	public static final int RECORD_SIZE = 2*DOUBLE_SIZE;
	
	public BankData()
	{
		conn = null;
	}
	
	//open connection to database
	public void open (String aProp_File) throws SQLException, IOException, ClassNotFoundException
	{
		SimpleDataSource.init(aProp_File);
		conn = SimpleDataSource.getConnection();
		stat = conn.createStatement();
		System.out.println("Database connected!");
	}
	
	//get number of account in the database
	public int size() throws SQLException
	{
		queryString = "SELECT MAX(ano) FROM BankAccount";
		ResultSet rs = stat.executeQuery(queryString);
		//System.out.println("Searching query..." + rs);
		rs.next();
		return rs.getInt(1) + 1;
	}
	
	//close the database connection
	public void close() throws SQLException
	{
		if (conn != null)
		{
			conn.close();
		}
		
		conn = null;
	}
	
	//read a savings account record
	public SavingsAccount read (int n) throws SQLException
	{
		queryString = "SELECT balance, interestRate FROM BankAccount " + "WHERE ano = " + n;
		ResultSet rs = stat.executeQuery(queryString);
		rs.next();
		double balance = Double.parseDouble(rs.getString(1));
		double interestRate = Double.parseDouble(rs.getString(2));
		SavingsAccount account = new SavingsAccount(interestRate);
		account.deposit(balance);
		return account;
	}
	
	//writes a saving account record to the database
	public void write (int n, SavingsAccount account) throws SQLException
	{
		if (isAccountExist(n))
		{
			queryString = "UPDATE BankAccount Set balance = " + account.getBalance() + ", interestRate = " + account.getInterestRate() + " WHERE ano = " + n;
			stat.executeUpdate(queryString);
		}
		else
		{
			queryString = "INSERT INTO BankAccount VALUES (" + n + ", " + account.getInterestRate() + ", " + account.getBalance() + ")";
			stat.executeUpdate(queryString);
			System.out.println(queryString);
		}
	}
	
	//check if account already exists in the database
	public boolean isAccountExist(int ano) throws SQLException
	{
		queryString = "SELECT ano FROM BankAccount WHERE ano = " + ano;
		ResultSet rs = stat.executeQuery(queryString);
		return rs.next();
	}
}













