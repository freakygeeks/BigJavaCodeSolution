//Chapter 24 - Exercise 24.9

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{
	public static void main (String[] args) throws IOException
	{
		final int ROOM_SIZE = 10;
		ChatRoom chatRoom = new ChatRoom(ROOM_SIZE);
		
		final int PORT = 8888;
		ServerSocket server = new ServerSocket(PORT);
		
		System.out.println("Waiting for chatters to connect...");
		
		Socket s;
		
		while (true)
		{
			s = server.accept();
			ChatService service = new ChatService(s, chatRoom);
			service.start();
		}
	}
}