//Chapter 26 - Project 26.1

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
   An XML parser for appointments.
*/
public class AppointmentParser
{

   private DocumentBuilder builder;
   
   public AppointmentParser() throws ParserConfigurationException
   {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(true);
      factory.setIgnoringElementContentWhitespace(true);
      builder = factory.newDocumentBuilder();
   }

   /**
      Parses an XML file containing a appointment
      @param fileName the name of the file
      @return a AppointmentCalendar object containing appointments in the XML file
   */
   public AppointmentCalendar parse(String fileName) 
      throws SAXException, IOException
   {
      File f = new File(fileName);
      Document doc = builder.parse(f);
      // get the <country> element
      return getAppointmentCalendar(doc.getDocumentElement());
   }

   /**
      Gets the appointment object
      @param e an <appointment> element 
      @return a AppointmentCalendar object containing appointments in the XML file
   */
   public AppointmentCalendar getAppointmentCalendar(Element e)
   {
      AppointmentCalendar ac = new AppointmentCalendar();
      NodeList children = e.getChildNodes();
      for (int i = 0; i < children.getLength(); i++)
      {
          addAppointment(ac, (Element)children.item(i));
      }
      return ac;
   }

   /**
      Adds a ploygon object to the drawing list
      @param a AppointmentCalendar object containing appointments in the XML file
      @param e an <appointment> element 
   */
   private void addAppointment(AppointmentCalendar ac, Element e)
   {
      NodeList children = e.getChildNodes();
      String description;
      String day;
      String from;
      String to;

      Element childElement = (Element)children.item(0);
      Text textNode = (Text)childElement.getFirstChild();
      description = textNode.getData();

      childElement = (Element)children.item(1);                
      textNode = (Text)childElement.getFirstChild();
      day = textNode.getData();
        
      childElement = (Element)children.item(2);                
      textNode = (Text)childElement.getFirstChild();
      from = textNode.getData();

      childElement = (Element)children.item(2);                
      textNode = (Text)childElement.getFirstChild();
      to = textNode.getData();
      
      ac.add(new Appointment(description + " " + day + " " +
                             from + " " + to));
   }
}
