//Chapter 26 - Project 26.1

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
   An appointment calendar.
*/
public class AppointmentCalendar
{  
   private ArrayList appointments;
   
   public AppointmentCalendar()
   { 
      appointments = new ArrayList();
   }

   /**
      Adds an appointment to the calendar.
      @param a the appointment to add
   */
   public void add(Appointment a)
   { 
      appointments.add(a);
   }
   
   /**
      Cancels an appointment from the calendar.
      @param a the appointment to cancel
   */   
   public void cancel(Appointment a)
   {  
      for (int i = 0; i < appointments.size(); i++)
      {  
         Appointment appt = (Appointment)appointments.get(i);
         if (appt.equals(a))
         {  
            appointments.remove(i);
            return;
         }
      }
      System.out.println("No matching appointment.");
   }

   /**
      Prints an appointment for a certain date.
      @param d the appointment to print
   */
   public void printForDay(AppointmentDate d)
   { 
      for (int i = 0; i < appointments.size(); i++)
      { 
         Appointment appt = (Appointment)appointments.get(i);
         if (appt.fallsOn(d))
            System.out.println(appt.print());
      }
   }

   /**
      Prints all appointments in the calendar.
   */
   public void printCalendar()
   {
      for (int i = 0; i < appointments.size(); i++)
      { 
         Appointment appt = (Appointment)appointments.get(i);
         System.out.println(appt.print());
      }      
   }

   /**
      Returns all the appointments.
      @return all the appointments
   */
   public ArrayList getAppointments()
   {  
      return appointments;
   }
}
