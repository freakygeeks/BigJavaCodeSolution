//Chapter 25 - Exercise 25.1

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Coin
{
	public static void main (String[] args) throws Exception
	{
		if (args.length == 0)
		{
			System.out.println("Usage : java Coin DBproperties");
			return;
		}

		SimpleDataSource.init(args[0]);
		Connection conn = SimpleDataSource.getConnection();
		
		try
		{
			Statement stat = conn.createStatement();
			stat.execute("CREATE TABLE Coin (Name CHAR(20), Price DECIMAL(4, 2))");
			stat.execute("INSERT INTO Coin VALUES ('penny', 0.01)");
			stat.execute("INSERT INTO Coin VALUES ('nickel', 0.05)");
			stat.execute("INSERT INTO Coin VALUES ('dime', 0.10)");
			stat.execute("INSERT INTO Coin VALUES ('quarter', 0.25)");
			stat.execute("INSERT INTO Coin VALUES ('half-dollar', 0.50)");
			stat.execute("INSERT INTO Coin VALUES ('dollar', 1.00)");
			
			ResultSet result = stat.executeQuery("SELECT SUM(Price) AS SumOfValues FROM Coin");
			result.next();
			
			System.out.print("The sum of the coin values : ");
			System.out.println(result.getString("SumOfValues"));
			result.close();
			stat.close();
		}
		finally
		{
			conn.close();
		}
	}
}













