//Chapter 25 - Example 25.3
//command : java -classpath E:\xampp\mysql-connector-java-3.1.14\mysql-connector-java-3.1.14-bin.jar;. TestDBSource database.properties
//command : java TestDBSource database.properties

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBSource
{
	public static void main (String[] args) throws Exception
	{
		if (args.length == 0)
		{
			System.out.println("Usage : java -classpath driver_class_path;." + "TestDBSource DBproperties");
			return;
		}
		else
		{
			SimpleDataSource.init(args[0]);
		}
		
		Connection conn = SimpleDataSource.getConnection();
		System.out.print("Database is connected !");
		
		try
		{
			Statement stat = conn.createStatement();
			
			//stat.execute("CREATE TABLE Test (Name CHAR(20))");
			stat.execute("INSERT INTO Test VALUES ('Bird')");
			
			ResultSet result = stat.executeQuery("SELECT * FROM Test");
			result.next();
			System.out.println(result.getString("Name"));
		}
		
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:" + e);
		}
		
		finally
		{
			conn.close();
		}
	}
}