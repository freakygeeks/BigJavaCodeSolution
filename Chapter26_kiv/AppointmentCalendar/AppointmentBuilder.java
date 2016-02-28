//Chapter 26 - Project 26.1

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
   Builds a DOM document for appointments
*/
public class AppointmentBuilder
{
   private DocumentBuilder builder;
   private Document doc;
   
   public AppointmentBuilder() throws ParserConfigurationException
   {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      builder = factory.newDocumentBuilder();
   }

   /**
      Builds a DOM document for appointments.
      @param appointments the appointments
      @return a DOM document describing the appointments
   */
   public Document build(ArrayList appointments)
   {
      doc = builder.newDocument();
      Element root = createAppointments(appointments);
      doc.appendChild(root);
      return doc;
   }

   /**
      Builds a DOM element for appointments
      @param appointments the appointments
      @return a DOM element describing the appointments
   */  
   private Element createAppointments(ArrayList appointments)
   {      
      Element appointmentElement = doc.createElement("appointments");
      for (int i = 0; i < appointments.size(); i++)
      {
         Appointment anAppointment = (Appointment)appointments.get(i);
         Element itemElement = createAppointment(anAppointment);
         appointmentElement.appendChild(itemElement);
      }
      return appointmentElement;
   }

   /**
      Builds a DOM element for appointment
      @param appointment the appointment
      @return a DOM element describing the appointment
   */  
   private Element createAppointment(Appointment appointment)
   {      
      Element appointmentElement = doc.createElement("appointment");

      Text descriptionText 
         = doc.createTextNode(appointment.getDescription());
      Element descriptionElement 
         = doc.createElement("description");
      descriptionElement.appendChild(descriptionText);

      Text dayText = doc.createTextNode("" + appointment.getDay());
      Element dayElement = doc.createElement("day");
      dayElement.appendChild(dayText);

      Text fromText = doc.createTextNode("" + appointment.getFrom());
      Element fromElement = doc.createElement("from");
      fromElement.appendChild(fromText);

      Text toText = doc.createTextNode("" + appointment.getTo());
      Element toElement = doc.createElement("to");
      toElement.appendChild(toText);

      appointmentElement.appendChild(descriptionElement);
      appointmentElement.appendChild(dayElement);
      appointmentElement.appendChild(fromElement);
      appointmentElement.appendChild(toElement);
      return appointmentElement;
   }
}

