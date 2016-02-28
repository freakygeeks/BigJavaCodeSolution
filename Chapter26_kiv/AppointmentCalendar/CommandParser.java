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
   An XML parser for commands.
*/
public class CommandParser
{
   private DocumentBuilder builder;
   private AppointmentCalendar ac;
   
   public CommandParser(AppointmentCalendar appCal) throws ParserConfigurationException
   {
      DocumentBuilderFactory factory 
         = DocumentBuilderFactory.newInstance();
      factory.setValidating(true);
      factory.setIgnoringElementContentWhitespace(true);
      builder = factory.newDocumentBuilder();
      ac = appCal;
   }

   /**
      Parses an XML file containing commands
      @param fileName the name of the file
   */
   public void parse(String fileName) 
      throws SAXException, IOException
   {
      File f = new File(fileName);
      Document doc = builder.parse(f);
      // get the <country> element
      executeCommand(doc.getDocumentElement());
   }

   /**
      Executes the command
      @param e an <command> element
   */
   public void executeCommand(Element e)
   {
      NodeList children = e.getChildNodes();
      for (int i = 0; i < children.getLength(); i++)
      {   
          modifyAppointmentCal((Element)children.item(i));
      }
   }

   /**
      Adds or remove an appiontment object from appointment calendar.
      @param e an <add> or <remove> element 
   */
   private void modifyAppointmentCal(Element e)
   {
      NodeList children = e.getChildNodes();

      // get the <appointment> element
      Element childElement = (Element)children.item(0);
      children = childElement.getChildNodes();

      String description;
      String day;
      String from;
      String to;

      childElement = (Element)children.item(0);
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
      
      if(e.getTagName().equals("add"))
      {
          ac.add(new Appointment(description + " " + day + " " +
                                 from + " " + to));
      } else if(e.getTagName().equals("remove"))
      {        
          ac.cancel(new Appointment(description + " " + day + " " +
                                 from + " " + to));
      }
   }
}

