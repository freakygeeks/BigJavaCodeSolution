//Chapter 25 - Exercise 25.9

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.IOException;

public class Airplane
{
	public static final int FIRST = 0;
	public static final int ECONOMY = 1;
	public static final int FIRST_ROW = 5;
	public static final int ECONOMY_ROW = 30;
	private FSeatRow firstClass;
	private ESeatRow economyClass;
	private Connection conn;
	private Statement stat;
	
	public Airplane (String aPropFile) throws SQLException, IOException, ClassNotFoundException
	{
		SimpleDataSource.init(aPropFile);
		conn = SimpleDataSource.getConnection();
		
		firstClass = new FSeatRow(conn);
		economyClass = new ESeatRow(conn);
	}
	
	//add passenger to the plane
	public void addPassengers (int tclass, int npassenger, int where) throws SQLException
	{
		if (tclass == FIRST)
		{
			if (firstClass.addPassengers(npassenger, where))
			{
				return;
			}
			else
			{
				if (economyClass.addPassengers(npassenger, where))
				{
					return;
				}
			}
		}
		System.out.println("Assignment did not succedd");
	}
	
	//print the seating of the airplane
	public void print() throws SQLException
	{
		String queryString = "SELECT * FROM FirstSeats";
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(queryString);
		
		while (rs.next())
		{
			System.out.println(rs.getString(1) + "\t" + stringFilter(rs.getString(2)) + " " + stringFilter(rs.getString(3)) + " " + stringFilter(rs.getString(4)) + " " + stringFilter(rs.getString(5)));
		}
		
		queryString = "SELECT * FROM EconomySeats";
		stat = conn.createStatement();
		rs = stat.executeQuery(queryString);
		
		while (rs.next())
		{
			System.out.println(rs.getString(1) + "\t" + stringFilter(rs.getString(2)) + " " + stringFilter(rs.getString(3)) + " " + stringFilter(rs.getString(4)) + " " + stringFilter(rs.getString(5)) + " " + stringFilter(rs.getString(6)) + " " + stringFilter(rs.getString(7)));
		}
	}
	
	public String stringFilter(String str)
	{
		return str.equals("A") ? " " : str;
	}
}
















