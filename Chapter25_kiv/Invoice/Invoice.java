//Chapter 25 - Exercise 25.5

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

public class Invoice
{
	public static void main (String[] args) throws Exception
	{
		if (args.length == 0)
		{
			System.out.println("Usage : java Invoice DBproperties");
			System.exit(0);
		}
		
		SimpleDataSource.init(args[0]);
		
		Connection conn = SimpleDataSource.getConnection();
		Statement stat = conn.createStatement();
		
		Reader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		
		System.out.print("Please enter invoice number: ");
		String line = in.readLine();
		
		try
		{
			int ino = Integer.parseInt(line);
			displayInvoice(stat, ino);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		in.close();
		stat.close();
		conn.close();
	}
	
	//display the invoice
	public static void displayInvoice (Statement stat, int aIno) throws SQLException
	{
		displayHeader(stat, aIno);
		displayBody(stat, aIno);
	}
	
	//display the header of the invoice
	public static void displayHeader (Statement stat, int aIno) throws SQLException
	{
		System.out.println("\n\t\t\tInvoice\n\n\n");
		String queryString = "SELECT c.name, c.address, c.city, c.state, c.zip " + "FROM Customer c, Invoice i " + "WHERE c.customer_number = i.customer_number " + "AND i.invoice_number = " + aIno;
		ResultSet result = stat.executeQuery(queryString);
		result.next();
		System.out.println(result.getString(1));
		System.out.println(result.getString(2));
		System.out.println(result.getString(3).trim() + ", " + result.getString(4) + " " + result.getString(5) + "\n\n");
		result.close();
	}
	
	//display the body of the invoice
	public static void displayBody (Statement stat, int aIno) throws SQLException
	{
		System.out.println("***************************************************\n");
		
		String queryString = "SELECT p.description, i.quantity, p.price, i.quantity*p.price " + "FROM Product p, Item i " + "WHERE p.product_code = i.product_code " + "AND i.invoice_number = " + aIno;
		ResultSet rs = stat.executeQuery(queryString);
		ResultSetMetaData rmsd = rs.getMetaData();
		int columnCount = rmsd.getColumnCount();
		rmsd.getColumnDisplaySize(1);
		System.out.print(stringFilter("Item", rmsd.getColumnDisplaySize(1), ' ') + stringFilter("Qty", 8, ' ') + stringFilter("Price", 8, ' ') + stringFilter("Total", 10, ' ') + "\n\n");
		
		double amountDue = 0;
		
		while (rs.next())
		{
			System.out.print(rs.getString(1));
			System.out.print(rs.getString(2) + "\t");
			System.out.print("$" + rs.getString(3) + "\t");
			System.out.print("$" + rs.getString(4));
			amountDue = amountDue + rs.getDouble(4);
			System.out.println("\n");
		}
		
		rs.close();
		
		System.out.println("**********************************************\n");
		System.out.println("AMOUNT DUE : $" + amountDue + "\n");
	}
	
	//stringFilter will fill up a string with character at the end up to the width of the size
	public static String stringFilter (String str, int size, char ch)
	{
		StringBuffer sb = new StringBuffer(size);
		sb.append(str);
		
		for (int i = str.length(); i < size; i++)
		{
			sb.append(ch);
		}
		
		return sb.toString();
	}
}











