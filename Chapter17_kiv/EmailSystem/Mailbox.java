//Chapter 17 - Exercise 17.8

import java.util.ArrayList;
import java.util.List;

public class Mailbox
{
	private List<Message> receivedEmails;
	private List<Message> sentEmails;
	
	public Mailbox()
	{
		receivedEmails = new ArrayList<Message>();
		sentEmails = new ArrayList<Message>();
	}
	
	public List<Message> getReceivedEmails()
	{
		return receivedEmails;
	}
	
	public List<Message> getSentEmails()
	{
		return sentEmails;
	}
	
	public void receiveEmail (Message email)
	{
		receivedEmails.add(email);
	}
	
	public void sendEmail(Message email)
	{
		sentEmails.add(email);
	}
}