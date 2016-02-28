//Chapter 24 - Exercise 24.7
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch21/c21_exp_21_7

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLAnalyzer
{
	public static void main (String[] args) throws IOException
	{
		String input = "";
		
		if (args.length == 1)
		{
			input = args[0];
		}
		else
		{
			System.out.println ("Usage : java URLAnalyzer full_hostname_:port_page "); //http://www.java.sun.com:80/index.html
			System.exit(0);
		}
		
		URL u = new URL(input);
		System.out.println("Protocol : " + u.getProtocol());
		System.out.println("Host : " + u.getHost());
		System.out.println("Port : " + u.getPort());
		System.out.println("File : " + u.getFile());
	}
}