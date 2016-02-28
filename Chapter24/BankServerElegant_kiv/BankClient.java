//Chapter 24 - Exercise 24.3
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch21/c21_exp_21_3

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
   This program tests the bank server.
*/
public class BankClient
{
   public static void main(String[] args) throws IOException
   {
      BankServer.main(null); // start server
      
      final int SBAP_PORT = 8888;
      Socket s = new Socket("localhost", SBAP_PORT);
      InputStream instream = s.getInputStream();
      OutputStream outstream = s.getOutputStream();
      Scanner in = new Scanner(instream);
      PrintWriter out = new PrintWriter(outstream); 
      
      String command = "DEPOSIT 3 1000\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      String response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "WITHDRAW 3 500\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "QUIT\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();

      s.close();      
      
      final int ADMIN_PORT = 8889;
      s = new Socket("localhost", ADMIN_PORT);
      instream = s.getInputStream();
      outstream = s.getOutputStream();
      in = new Scanner(instream);
      out = new PrintWriter(outstream);
      
      command = "LOGIN secret\n"; // the default password is "secret"
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);

      command = "PASSWORD s3cr37\n"; 
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "LOGOUT\n"; 
      System.out.print("Sending: " + command);
      out.print(command);
      
      s.close();            

      s = new Socket("localhost", ADMIN_PORT);
      instream = s.getInputStream();
      outstream = s.getOutputStream();
      in = new Scanner(instream);
      out = new PrintWriter(outstream);
      
      command = "LOGIN s3cr37\n"; 
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);

      command = "STATUS\n"; 
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "SHUTDOWN\n"; 
      System.out.print("Sending: " + command);
      out.print(command);           
      out.flush();
   }
}


