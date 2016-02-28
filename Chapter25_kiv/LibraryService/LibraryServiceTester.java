//Chapter 25 - Exercise 25.7

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.IOException;
import java.io.Reader;

public class LibraryServiceTester
{
	public static void main (String[] args) throws Exception
	{
		if (args.length == 0)
		{
			System.out.println("Usage : java LibraryServiceTester DBproperties");
			System.exit(0);
		}
		
		LibraryService ls = new LibraryService(args[0]);
		ls.startService();
	}
}