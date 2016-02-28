//Chapter 25 - Example 25.4
//command : java -classpath E:\xampp\mysql-connector-java-3.1.14\mysql-connector-java-3.1.14-bin.jar;. ExecSql database.properties Product.sql
//command : java ExecSql database.properties Product.sql

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecSql
{
	public static void main (String[] args) throws SQLException, IOException, ClassNotFoundException
	{
		if (args.length == 0)
		{
			System.out.println ("Usage : java ExecSql DBproperties SqlCommandFile");
			return;
		}
		
		SimpleDataSource.init(args[0]);
		Scanner in;
		
		if (args.length > 1)
		{
			in = new Scanner (new FileReader(args[1]));
		}
		else
		{
			in = new Scanner(System.in);
		}
		
		Connection conn = SimpleDataSource.getConnection();
		
		try
		{
			Statement stat = conn.createStatement();
			while (in.hasNextLine())
			{
				String line = in.nextLine();
				boolean hasResultSet = stat.execute(line);
				
				if (hasResultSet)
				{
					ResultSet result = stat.getResultSet();
					showResultSet(result);
					result.close();
				}
			}
		}
		finally
		{
			conn.close();
		}
	}
	
	//print result
	public static void showResultSet(ResultSet result) throws SQLException
	{
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		for (int i = 1; i <= columnCount; i++)
		{
			if (i > 1)
			{
				System.out.print(",");
			}
			System.out.print(metaData.getColumnLabel(i));
		}
		
		System.out.println();
		
		while (result.next())
		{
			for (int i = 1; i <= columnCount; i++)
			{
				if (i > 1)
				{
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}
}













