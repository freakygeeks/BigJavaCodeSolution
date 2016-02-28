//Chapter 17 - Exercise 17.8

public class User
{
	private String name;
	private String password;
	private Mailbox mailbox;
	
	public User (String aName, String aPassword)
	{
		name = aName;
		password = aPassword;
		mailbox = new Mailbox();
	}
	
	public boolean match (String aName, String aPassword)
	{
		return name.equals(aName) && password.equals(aPassword);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public Mailbox getMailbox()
	{
		return mailbox;
	}
}