//Chapter 25 - Exercise 25.9

import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class ExecSQL
{
	public static void main (String[] args)
	{
		try
		{
			if (args.length == 0)
			{
				System.out.println("Usage : java ExecSQL DBproperties [statementFile]");
				System.exit(0);
			}
			
			Connection con = getConnection(args[0]);
			Statement stmt = con.createStatement();
			
			String tableName = "";
			Reader reader;
			
			if (args.length > 1)
			{
				reader = new FileReader(args[1]);
			}
			else 
			{
				reader = new InputStreamReader(System.in);
			}
			
			BufferedReader in = new BufferedReader(reader);
			String line;
			
			while ((line = in.readLine()) != null)
			{
				boolean hasResultSet = stmt.execute(line);
				if (hasResultSet)
				{
					showResultSet(stmt);
				}
			}
			
			in.close();
			stmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			System.out.println("SQLException : ");
			
			while (e != null)
			{
				System.out.println("SQLState : " + e.getSQLState());
				System.out.println("Message : " + e.getMessage());
				System.out.println("Vendor : " + e.getErrorCode());
				
				e = e.getNextException();
				System.out.println("");
			}
		}
		catch (IOException e)
		{
			System.out.println("IOException : " + e);
			e.printStackTrace();
		}
	}
	
	//open database connection
	public static Connection getConnection(String fileName) throws SQLException, IOException
	{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);
		
		String drivers = props.getProperty("jdbc.driver");
		
		if (drivers != null)
		{
			System.setProperty("jdbc.driver", drivers);
		}
		
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void showResultSet(Statement stmt) throws SQLException
	{
		ResultSet rs = stmt.getResultSet();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		while (rs.next())
		{
			for (int i = 1; i <= columnCount; i++)
			{
				if (i > 1)
				{
					System.out.print(", ");
				}
				
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
	}
}





















