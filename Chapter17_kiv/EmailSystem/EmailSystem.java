//Chapter 17 - Exercise 17.8

import java.util.List;

public class EmailSystem
{
	private User currentUser;
	private Mailbox currentMailbox;
	private UserDatabase usersDB;
	private int state;
	protected static final int START = 1;
	protected static final int ACCOUNT = 2;
	protected static final int WRITE_EMAIL = 3;
	protected static final int READ_RECEIVED = 4;
	protected static final int READ_SENT = 5;
	
	public EmailSystem (UserDatabase users_DB)
	{
		usersDB = users_DB;
		reset();
	}
	
	public void reset()
	{
		state = START;
		currentUser = null;
		currentMailbox = null;
	}
	
	public void sendEmail (String recipientName, Message email)
	{
		User recipientUser = usersDB.findUser(recipientName);
		if (recipientUser != null)
		{
			currentMailbox.sendEmail(email);
			Mailbox recipientMailbox = recipientUser.getMailbox();
			recipientMailbox.receiveEmail(email);
		}
	}
	
	public boolean canLoginUser (String username, String password)
	{
		User u = usersDB.findUser(username, password);
		if (u != null)
		{
			currentUser = u;
			return true;
		}
		return false;
	}
	
	public List<Message> getSentEmails()
	{
		return currentMailbox.getSentEmails();
	}
	
	public List<Message> getReceivedEmails()
	{
		return currentMailbox.getReceivedEmails();
	}
	
	public Message getMachingEmail (String title, List<Message> emails)
	{
		for (Message email : emails)
		{
			if (email.match(title))
			{
				return email;
			}
		}
		return null;
	}

	public int getState()
	{
		return state;
	}
	
	public void setState (int state)
	{
		state = state;
	}
}



























