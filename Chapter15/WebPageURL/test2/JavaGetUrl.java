//------------------------------------------------------------//
//  JavaGetUrl.java:                                          //
//------------------------------------------------------------//
//  A Java program that demonstrates a procedure that can be  //
//  used to download the contents of a specified URL.         //
//------------------------------------------------------------//
//  Code created by Developer's Daily                         //
//  <a href="http://www.DevDaily.com" title="http://www.DevDaily.com">http://www.DevDaily.com</a>                                   //
//------------------------------------------------------------//
 
import java.io.*;
import java.net.*;
 
public class JavaGetUrl 
{
 
   public static void main (String[] args) 
   {
 
      //-----------------------------------------------------//
      //  Step 1:  Start creating a few objects we'll need.
      //-----------------------------------------------------//
 
      URL u;
      InputStream is = null;
      DataInputStream dis;
      String s;
 
      try 
	  {
 
         //------------------------------------------------------------//
         // Step 2:  Create the URL.                                   //
         //------------------------------------------------------------//
         // Note: Put your real URL here, or better yet, read it as a  //
         // command-line arg, or read it from a file.                  //
         //------------------------------------------------------------//
 
         u = new URL("http://200.210.220.1:8080/index.html");
 
         //----------------------------------------------//
         // Step 3:  Open an input stream from the url.  //
         //----------------------------------------------//
 
         is = u.openStream();         // throws an IOException
 
         //-------------------------------------------------------------//
         // Step 4:                                                     //
         //-------------------------------------------------------------//
         // Convert the InputStream to a buffered DataInputStream.      //
         // Buffering the stream makes the reading faster; the          //
         // readLine() method of the DataInputStream makes the reading  //
         // easier.                                                     //
         //-------------------------------------------------------------//
 
         dis = new DataInputStream(new BufferedInputStream(is));
 
         //------------------------------------------------------------//
         // Step 5:                                                    //
         //------------------------------------------------------------//
         // Now just read each record of the input stream, and print   //
         // it out.  Note that it's assumed that this problem is run   //
         // from a command-line, not from an application or applet.    //
         //------------------------------------------------------------//
 
         while ((s = dis.readLine()) != null) 
		 {
            System.out.println(s);
         }
 
      } catch (MalformedURLException mue) 
	  {
 
         System.out.println("Ouch - a MalformedURLException happened.");
         mue.printStackTrace();
         System.exit(1);
 
      } catch (IOException ioe) 
	  {
 
         System.out.println("Oops- an IOException happened.");
         ioe.printStackTrace();
         System.exit(1);
 
      } finally 
	  {
 
         //---------------------------------//
         // Step 6:  Close the InputStream  //
         //---------------------------------//
 
         try 
		 {
            is.close();
         } catch (IOException ioe) 
		 {
            // just going to ignore this one
         }
 
      } // end of 'finally' clause
 
   }  // end of main
 
} // end of class definition