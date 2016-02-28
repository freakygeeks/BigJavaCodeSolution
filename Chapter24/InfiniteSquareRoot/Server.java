//Chapter 24 - Exercise 24.5

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.Double;

public class Server
{
	public static void main (String[] args) throws IOException
	{
		final int PORT = 8888;
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Waiting for clients to connect ...");
		
		while (true)
		{
			Socket s = server.accept();
			Service service = new Service(s);
			service.doService();
			s.close();
		}
	}
}