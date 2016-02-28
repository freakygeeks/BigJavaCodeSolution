//Chapter 24 - Exercise 24.3

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
   A server that executes the Simple Bank Access Protocol. It provides an
   administration service on port 8889.
*/
public class BankServer
{  
   public static void main(String[] args)
   {  
      final int ACCOUNTS_LENGTH = 10;
      final Bank bank = new Bank(ACCOUNTS_LENGTH);
      final AdminData adminData = new AdminData();
      final int SBAP_PORT = 8888;
      final int ADMIN_PORT = 8889;      
      
      class ServiceRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               ServerSocket server = new ServerSocket(SBAP_PORT);
               while (true)
               {
                  System.out.println("Waiting for clients to connect...");
                  Socket s = server.accept();
                  System.out.println("Client connected.");
                  BankService service = new BankService(s, bank);
                  adminData.incrementCustomerCount();
                  Thread t = new Thread(service);
                  t.start();
               }
            }
            catch(IOException exception)
            {
               System.out.println(exception);
               System.exit(1);
            }
         }
      }
      
      class AdminRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               ServerSocket admin = new ServerSocket(ADMIN_PORT);
               while (true)
               {
                  Socket s = admin.accept();
                  System.out.println("Administrator connected.");
                  AdministrationService service = new AdministrationService(s, adminData);
                  Thread t = new Thread(service);
                  t.start();
               }
            }
            catch(IOException exception)
            {
               System.out.println(exception);
               System.exit(1);
            }
         }
      }
      
      ServiceRunnable service = new ServiceRunnable();
      Thread t1 = new Thread(service);
      t1.start();

      AdminRunnable admin = new AdminRunnable();
      Thread t2 = new Thread(admin);
      t2.start();
   }
}