//Chapter 24 - Exercise 24.9

import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.PrintWriter;

public class ChatRoom
{
	private ArrayList activeService;
	private HashMap chatterHash;
	public int capacity;
	
	public ChatRoom(int aCapacity)
	{
		capacity = aCapacity;
	}
	
	//register a chatter to the room
	public void register (String aName)
	{
		chatterHash.put(aName, new Chatter(aName));
	}
	
	//de-register a chatter from a room
	public void leave (String aName)
	{
		chatterHash.remove(aName);
	}
	
	public void add (ChatService cs)
	{
		activeService.add(cs);
	}
	
	//broadcast message to everyone in the room
	public void broadcast (String requestor, String msg, ChatService chatService)
	{
		ListIterator li = activeService.listIterator();
		
		while (li.hasNext())
		{
			ChatService cs = (ChatService) li.next();
			
			if (cs != chatService && cs.getUserName() != null)
			{
				cs.putMessage(requestor + " : " + msg);
			}
		}
	}
}














