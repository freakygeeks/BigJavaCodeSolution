//Chapter 25 - Exercise 25.7

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LibraryService
{
	private Connection conn;
	private Statement stat;
	private BufferedReader jin;
	private String queryString;
	private String command = "";
	private int input;
	
	public LibraryService (String aProp_File) throws Exception
	{
		SimpleDataSource.init(aProp_File);
		conn = SimpleDataSource.getConnection();
		stat = conn.createStatement();
		jin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//stat library service
	public void startService() throws IOException, SQLException
	{
		System.out.println("\nWelcome to the library's virtual front desk!\n");
		
		try
		{
			try
			{
				do
				{
					printMenu();
					System.out.print("Please enter your choice : ");
					input = Integer.parseInt(jin.readLine());
					switch(input)
					{
						case 1 : doCheckout();
						break;
						
						case 2 : doReturn();
						break;
						
						case 3 : checkOutBooks();
						break;
						
						case 4 : findPatron();
						break;
						
						default : break;
					}
				}
				
				while (input != 5);
			}
			
			catch (SQLException e)
			{
				System.out.println(e);
			}
			finally
			{
				if (stat != null)
				{
					stat.close();
				}
			}
		}
		
		catch (SQLException e)
		{
			System.out.println(e);
		}
		finally
		{
			if (conn != null)
			{
				conn.close();
			}
		}
	}
	
	//print out user menu
	public void printMenu()
	{
		System.out.println("\n1) Check out books");
		System.out.println("2) Return books");
		System.out.println("3) Books that a patron has checked out");
		System.out.println("4) Find who has checked out a particular book");
		System.out.println("5) Done\n");
	}
	
	//method for book checkout process
	public void doCheckout() throws IOException, SQLException
	{
		do
		{
			System.out.print("Please enter patron ID : ");
			int pid = Integer.parseInt(jin.readLine());
			
			System.out.print("Please enter book ID : ");
			int bid = Integer.parseInt(jin.readLine());
			
			if (isPatronExist(pid))
			{
				queryString = "UPDATE Books " + "SET pid = " + pid + " WHERE bid = " + " AND pid = -1";
				
				if (stat.executeUpdate(queryString) == 1)
				{
					System.out.println("\nTransaction success!");
				}
				else
				{
					System.out.println("\nEither someone already borrowed the book or there is no such book ID");
				}
			}
			else
			{
				System.out.println("No such patron ID!");
			}
			
			System.out.print("\nDo you wish to continue? (y/n)");
			command = jin.readLine();
		}
		
		while (command.equals("y"));
	}
	
	//book return procedure
	public void doReturn() throws IOException, SQLException
	{
		do
		{
			System.out.print("Please enter patron ID : ");
			int pid = Integer.parseInt(jin.readLine());
			
			System.out.print("Please enter book ID : ");
			int bid = Integer.parseInt(jin.readLine());
			
			if (isPatronExist(pid))
			{
				queryString = "UPDATE Books " + "SET pid = -1 " + "WHERE bid = " + " AND pid = " + pid;
				
				if (stat.executeUpdate(queryString) == 1)
				{
					System.out.println("\nTransaction success!");
				}
				else
				{
					System.out.println("\nEither you did not borrow the book or there is no such book ID");
				}
			}
			else
			{
				System.out.println("No such patron ID!");
			}
			
			System.out.print("\nDo you wish to continue? (y/n)");
			command = jin.readLine();
		}
		
		while (command.equals("y"));
	}
	
	//ask user for a patron ID and finds all books that patron borrowed
	public void checkOutBooks() throws IOException, SQLException
	{
		do
		{
			System.out.print("Please enter patron ID : ");
			int pid = Integer.parseInt(jin.readLine());
			
			if (isPatronExist(pid))
			{
				queryString = "SELECT bid, isbn, author, title " + "FROM books " + "WHERE pid = " + pid;
				ResultSet rs = stat.executeQuery(queryString);
				System.out.println("BookID    ISBN   Author        Title");
				
				while (rs.next())
				{
					StringBuffer sb = new StringBuffer(stringFilter(rs.getString(1), 9, ' '));
					sb.append(stringFilter(rs.getString(2), 14, ' '));
					sb.append(rs.getString(3));
					sb.append(rs.getString(4));
					System.out.println(sb.toString());
				}
			}
			
			else
			{
				System.out.println("No such patron ID");
			}
			
			System.out.print("\nDo you wish to continue? (y/n)");
			command = jin.readLine();
		}
		
		while (command.equals("y"));
	}
	
	//ask for a book ID and find the patron name
	public void findPatron() throws IOException, SQLException
	{
		do 
		{
			System.out.print("Please enter book ID : ");
			int bid = Integer.parseInt(jin.readLine());
			
			if (isBookExist(bid))
			{
				queryString = "SELECT p.name " + "FROM books b, patrons p " + "WHERE b.bid = " + bid + " AND b.pid = p.pid";
				ResultSet rs = stat.executeQuery(queryString);
				
				if (rs.next())
				{
					System.out.println("Patron's name : " + rs.getString(1));
				}
				else
				{
					System.out.println("No one checked out this book");
				}
			}
			else
			{
				System.out.println("No such book ID");
			}
			
			System.out.print("\nDo you wish to continue? (y/n)");
			command = jin.readLine();
		}
		
		while (command.equals("y"));
	}
	
	//check if patron exist in database
	public boolean isPatronExist(int aPID) throws SQLException
	{
		queryString = "SELECT PID FROM Patrons WHERE pid = " + aPID;
		ResultSet rs = stat.executeQuery(queryString);
		return rs.next();
	}
	
	//check if book exist in database
	public boolean isBookExist(int aBID) throws SQLException
	{
		queryString = "SELECT bid FROM Books WHERE bid = " + aBID;
		ResultSet rs = stat.executeQuery(queryString);
		return rs.next();
	}
	
	//stringFilter fill up a str with character at the end up to the width of the size
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

















