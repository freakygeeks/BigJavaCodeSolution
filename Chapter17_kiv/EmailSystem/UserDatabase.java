//Chapter 17 - Exercise 17.8

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDatabase
{
	private List<User> users;
	
	public UserDatabase()
	{
		users = new ArrayList<User>();
	}
	
	public UserDatabase(String filename) throws FileNotFoundException
	{
		readUser(filename);
	}
	
	public void readUser(String filename) throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File(filename));
		
		while (inFile.hasNext())
		{
			String username = inFile.next();
			String password = inFile.next();
			System.out.println(username);
			System.out.println(password);
			
			User u = new User(username, password);
			addUser(u);
		}
		
		inFile.close();
	}
	
	public void addUser (User user)
	{
		users.add(user);
	}
	
	public User findUser (String username, String password)
	{
		for (User user : users)
		{
			if (user.match(username, password))
			{
				return user;
			}
		}
		return null;
	}
	
	public User findUser(String username)
	{
		for (User user : users)
		{
			if (user.getName().equals(username))
			{
				return user;
			}
		}
		return null;
	}
}




















