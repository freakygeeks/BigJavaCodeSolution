//Chapter 24 - Exercise 24.9

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ChatService extends Thread
{
	private String userName;
	private Socket s;
	private ChatRoom chatRoom;
	private PrintWriter out = null;
	
	public ChatService(Socket aSocket, ChatRoom aChatRoom)
	{
		s = aSocket;
		chatRoom = aChatRoom;
	}
	
	//execute all command until LOGOUT command or end of input
	public void run()
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream());
			
			while (true)
			{
				String line = in.readLine();
				
				if (line == null)
				{
					return;
				}
				
				if (line.trim().length() == 0)
				{
					continue;
				}
				
				String response = executeCommand(line, out);
				putMessage(response);
				
				if (line.equals("LOGOUT"))
				{
					return;
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//send message through the socket
	public synchronized void putMessage (String msg)
	{
		if (out != null)
		{
			out.println(msg);
			out.flush();
		}
	}
	
	//executes a single command
	public String executeCommand (String line, PrintWriter out)
	{
		StringTokenizer token = new StringTokenizer(line, " ", true);
		String command = token.nextToken();
		
		if (command.equals("LOGIN"))
		{
			token.nextToken();
			userName = token.nextToken();
			chatRoom.register(userName);
			chatRoom.broadcast(userName, "LOGIN", this);
			return "Chat Room Manager : Hello, " + userName + ".";
		}
		
		else if (command.equals("CHAT"))
		{
			StringBuffer st = new StringBuffer();
			
			while (token.hasMoreTokens())
			{
				st.append(token.nextToken());
			}
			
			chatRoom.broadcast(userName, st.toString(), this);
			return userName + " : " + st.toString();
		}
		
		else if (!command.equals("LOGOUT"))
		{
			return "Chat Room Manager : Invalid Command";
		}
		
		chatRoom.broadcast(userName, "LOGOUT", this);
		chatRoom.leave(userName);
		return "Good-Bye!\n";
	}
	
	//return the user name of this service
	public String getUserName()
	{
		return userName;
	}
}











