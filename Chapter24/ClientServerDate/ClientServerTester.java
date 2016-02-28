//Chapter 24 - Exercise 24.6
//http://beta.code-check.org/codecheck/files?repo=bj4fp&problem=ch21/c21_exp_21_6
//http://cs.lmu.edu/~ray/notes/javanetexamples/

import java.io.IOException;

public class ClientServerTester
{
   public static void main(String[] args) throws InterruptedException
   {
      // start the server
      class ServerRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               DateServer.main(new String[] {});
            }
            catch (IOException ex)
            {
               ex.printStackTrace();
            }
         }
      };
      Thread t1 = new Thread(new ServerRunnable());
      t1.start();
      
      
      // start the client
      class ClientRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               DateClient.main(new String[] {});
            }
            catch (IOException ex)
            {
               ex.printStackTrace();
            }
         }
      };
      
      Thread t2 = new Thread(new ClientRunnable());
      t2.start();
      t2.join();
      System.exit(0);
   }
}
