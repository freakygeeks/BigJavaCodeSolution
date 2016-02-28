//Chapter 26 - Project 26.1

import java.util.ArrayList;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
   Reads appointments from a XML file with DTD and add them into 
   appoitment calendar.  Then, it will print all the appointments
   out. Then, it reads commands from a XML file with DTD and 
   parse those commands and print the new appointment calendar in
   XML.
*/
public class AppointmentTester
{
   public static void main(String[] args) throws Exception
   {
       AppointmentParser ap = new AppointmentParser();
       AppointmentCalendar ac = ap.parse("appointment.xml");
       System.out.println("Before parse command:");
       ac.printCalendar();
       System.out.println("\nAfter parse command:");
       CommandParser cp = new CommandParser(ac);
       cp.parse("commands.xml");

       AppointmentBuilder builder = new AppointmentBuilder();
       Document doc = builder.build(ac.getAppointments());         
       Transformer t = TransformerFactory.newInstance().newTransformer();
       t.transform(new DOMSource(doc), new StreamResult(System.out));
   }
}
