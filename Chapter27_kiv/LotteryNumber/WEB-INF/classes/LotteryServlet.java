import java.io.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class LotteryServlet extends HttpServlet 
{
  protected final int DEFAULT_NUMBER = 6;
 
  /** Called when the form is filled in by the user. */
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException 
  {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter( );
	
	int n = DEFAULT_NUMBER;
    String one=req.getParameter("first");
	String two=req.getParameter("second");
	String three=req.getParameter("third");
	String four=req.getParameter("fourth");
	String five=req.getParameter("fifth");
	String six=req.getParameter("sixth");
  
    // The usual HTML setup stuff.
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<BODY BGCOLOR=\"white\">");
 
    // HTML for this page
    out.println("<TITLE>Your Personal Random Numbers</TITLE>");
    out.println("<H1>Your Personal Random Numbers</h2>");
    out.println("<A HREF=\"index.html\">Back to main Page</A>");
    out.println("<P>Here are your chosen numbers : " + one + ","+ two + "," + three + "," + four + "," + five + "," + six);
	out.println("<P>Here are your random numbers : ");

    // Now actually generate some random numbers.
    Random r = new Random( );
    for (int i=0; i<n; i++) 
	{
      out.println(r.nextInt(60) + ",");  // for Lotto 6/49
	  out.println("</HTML>");
	}
	}
}