//Chapter 25 - Example 25.3

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestDB
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/cdcol","root", "toor123456");
			System.out.print("Database is connected !");

			Statement stat = conn.createStatement();

			stat.execute("CREATE TABLE Test (Name VARCHAR(20))");
			stat.execute("INSERT INTO Test VALUES ('Siti')");

			ResultSet result = stat.executeQuery("SELECT * FROM Test");
			result.next();
			System.out.println(result.getString("Name"));

			conn.close();
		}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
}