//Chapter 25 - Exercise 25.9

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ESeatRow
{
	public static final int WINDOW = 0;
	public static final int CENTER = 1;
	public static final int AISLE = 2;
	private Connection conn;
	private Statement stat;
	private boolean[] occupied;
	
	public ESeatRow (Connection aConn)
	{
		conn = aConn;
	}
	
	//add passengers to the seat
	public boolean addPassengers (int npassenger, int where) throws SQLException
	{
		if (npassenger > 3)
		{
			return false;
		}
		if (where == WINDOW)
		{
			return addWinSeat(npassenger);
		}
		else if (where == CENTER)
		{
			return addCenterSeat(npassenger);
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
		String queryString = "SELECT * FROM EconomySeats";
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(queryString);
		
		if (npassenger == 1)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(2)))
				{
					queryString = "UPDATE EconomySeats SET Lwin = 'O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(7)))
				{
					queryString = "UPDATE EconomySeats SET Rwin='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
			}
		}
		else if (npassenger == 2)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(2)) && isSeatAvailable(rs.getString(3)))
				{
					queryString = "UPDATE EconomySeats SET Lwin='O', Lcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(6)) && isSeatAvailable(rs.getString(7)))
				{
					queryString = "UPDATE EconomySeats SET Rwin='O', Rcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
			}
		}
		else if (npassenger == 3)
		{
			return addThreePassenger(rs);
		}
		
		return false;
	}
	
	//add three passengers
	public boolean addThreePassenger (ResultSet rs) throws SQLException
	{
		String queryString;
		
		while (rs.next())
		{
			if (isSeatAvailable(rs.getString(2)) && isSeatAvailable(rs.getString(3)) && isSeatAvailable(rs.getString(4)))
			{
				queryString = "UPDATE EconomySeats SET Lwin='O', Lcenter='O', Laisle='O' WHERE sid = " + rs.getString(1);
				stat.executeUpdate(queryString);
				return true;
			}
			else if (isSeatAvailable(rs.getString(5)) && isSeatAvailable(rs.getString(6)) && isSeatAvailable(rs.getString(7)))
			{
				queryString = "UPDATE EconomySeats SET Rwin='O', Rcenter='O', Raisle='O' WHERE sid = " + rs.getString(1);
				stat.executeUpdate(queryString);
				return true;
			}
		}
		
		return false;
	}
	
	//add center seats
	public boolean addCenterSeat (int npassenger) throws SQLException
	{
		String queryString = "SELECT * FROM EconomySeats";
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(queryString);
		
		if (npassenger == 1)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(3)))
				{
					queryString = "UPDATE EconomySeats SET Lcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(6)))
				{
					queryString = "UPDATE EconomySeats SET Rcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
			}
		}
		else if (npassenger == 2)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(2)) && isSeatAvailable(rs.getString(3)))
				{
					queryString = "UPDATE EconomySeats SET Lwin='O', Lcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(3)) && isSeatAvailable(rs.getString(4)))
				{
					queryString = "UPDATE EconomySeats SET Lcenter='O', Laisle='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(5)) && isSeatAvailable(rs.getString(6)))
				{
					queryString = "UPDATE EconomySeats SET Raisle='O', Rcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(6)) && isSeatAvailable(rs.getString(7)))
				{
					queryString = "UPDATE EconomySeats SET Rcenter='O', Rwin='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
			}
		}
		else if (npassenger == 3)
		{
			return addThreePassenger(rs);
		}
		return false;
	}
	
	//add aisle seats
	public boolean addAisleSeat (int npassenger) throws SQLException
	{
		String queryString = "SELECT * FROM EconomySeats";
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(queryString);
		
		if (npassenger == 1)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(4)))
				{
					queryString = "UPDATE EconomySeats SET Laisle='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(5)))
				{
					queryString = "UPDATE EconomySeats SET Raisle='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
			}
		}
		else if (npassenger == 2)
		{
			while (rs.next())
			{
				if (isSeatAvailable(rs.getString(3)) && isSeatAvailable(rs.getString(4)))
				{
					queryString = "UPDATE EconomySeats SET Laisle='O', Lcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
				}
				else if (isSeatAvailable(rs.getString(5)) && isSeatAvailable(rs.getString(6)))
				{
					queryString = "UPDATE EconomySeats SET Raisle='O', Rcenter='O' WHERE sid = " + rs.getString(1);
					stat.executeUpdate(queryString);
					return true;
					
				}
			}
		}
		else if (npassenger == 3)
		{
			return addThreePassenger(rs);
		}
		
		return false;
	}
	
	//return seat availability
	public boolean isSeatAvailable(String str)
	{
		return str.equals("A");
	}
}




















