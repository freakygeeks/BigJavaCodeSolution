//Chapter 25 - Exercise 25.7

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SimpleDataSource
{
	private static String url;
	private static String username;
	private static String password;
	
	public static void init (String filename) throws IOException, ClassNotFoundException
	{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(filename);
		props.load(in);
		
		String driver = props.getProperty("jdbc.driver");
		url = props.getProperty("jdbc.url");
		username = props.getProperty("jdbc.username");
		password = props.getProperty("jdbc.password");
		
		Class.forName(driver);
	}
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, username, password);
	}
}