//Chapter 24 - Exercise 24.8
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch21/c21_exp_21_8
//http://www.ntu.edu.sg/home/ehchua/programming/webprogramming/HTTP_Basics.html

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GetRequest
{
	public static void main (String[] args) throws IOException
	{
		//get command line arguments
		if (args.length != 1)
		{
			System.out.println ("Usage : java GetHeader filename");
			System.exit(0);
		}
		
		String filename = args[0];
		
		//host and port to server
		String host = "127.0.0.1";
		int port = 8080;
		
		//TCP socket to server
		Socket s = new Socket(host, port);
		
		//create input and output stream for network socket
		BufferedReader in = new BufferedReader (new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter (s.getOutputStream(), true);
		
		//send request to HTTP server
		out.println("GET /" + filename + " HTTP/1.0");
		out.println();
		out.flush();
		
		//read response and display on console
		String line = in.readLine();
		System.out.println(line);
		
		//close the I/O streams
		in.close();
		out.close();
	}
}