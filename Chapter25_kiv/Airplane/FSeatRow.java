//Chapter 25 - Exercise 25.9

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class FSeatRow
{
	public static final int WINDOW = 0;
	public static final int AISLE = 0;
	private Connection conn;
	private Statement stat;
	private boolean[] occupied;
	
	public FSeatRow(Connection aConn)
	{
		conn = aConn;
	}
	
	//add passengers to the seat
	public boolean addPassengers(int npassenger, int where) throws SQLException
	{
		if (npassenger > 2)
		{
			return false;
		}
		
		if (where == WINDOW)
		{
			return addWinSeat(npassenger);
		}
		else if (where == AISLE)
		{
			return addAisleSeat(npassenger);
		}
		else
		{
			return false;
		}
	}
	
	//add window seat
	public boolean addWinSeat(int npassenger) throws SQLException
	{
		String queryString = "SELECT * FROM FirstSeats";
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(queryString);
		
		if (npassenger == 1)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(2)))
				{
					queryString = "UPDATE FirstSeats SET Lwin='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(5)))
				{
					queryString = "UPDATE FirstSeats SET Rwin='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}				
			}
		}
		else if (npassenger == 2)
		{
			return addTwoPassenger(rs);
		}
		
		return false;
	}
	
	//add two passenger
	public boolean addTwoPassenger (ResultSet rs) throws SQLException
	{
		String queryString;
		
		while (rs.next())
		{
			if (isSeatAvailable(rs.getString(2)) && isSeatAvailable(rs.getString(3)))
			{
				queryString = "UPDATE FirstSeats SET Lwin='O', Laisle='O' WHERE sid = " + rs.getString(1);
				stat.executeUpdate(queryString);
				return true;
			}
			else if (isSeatAvailable(rs.getString(5)) && isSeatAvailable(rs.getString(5)))
			{
				queryString = "UPDATE FirstSeats SET Rwin='O', Raisle='O' WHERE sid = " + rs.getString(1);
				stat.executeUpdate(queryString);
				return true;
			}
		}
		
		return false;
	}
	
	//add aisle seats
	public boolean addAisleSeat (int npassenger) throws SQLException
	{
		String queryString = "SELECT * FROM FirstSeats";
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(queryString);
		
		if (npassenger == 1)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(3)))
				{
					queryString = "UPDATE FirstSeats SET Laisle='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(4)))
				{
					queryString = "UPDATE FirstSeats SET Raisle='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
			}
		}
		else if (npassenger == 2)
		{
			return addTwoPassenger(rs);
		}
		return false;
	}
	
	//return seat available
	public boolean isSeatAvailable(String str)
	{
		return str.equals("A");
	}
}























