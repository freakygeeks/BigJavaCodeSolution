//Chapter 26 - Project 26.1

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
   An appointment.
*/
public class Appointment
{ 
   private String description;
   private AppointmentDate day;
   private AppointmentTime from;
   private AppointmentTime to;
   
   public Appointment(String s)
   { 
      StringTokenizer tokenizer = new StringTokenizer(s);
      int descriptionCount = tokenizer.countTokens() - 3;
      description = "";
      for (int i = 1; i <= descriptionCount; i++)
      { 
         description += tokenizer.nextToken();
         if (i < descriptionCount) 
            description += " ";
      }
      day = new AppointmentDate(tokenizer.nextToken());
      from = new AppointmentTime(tokenizer.nextToken());
      to = new AppointmentTime(tokenizer.nextToken());
   }

   /**
      Determines if this appointment is the same as another appointment.
      @param other the other appointment
      @return true if the appointments are equal, false otherwise
   */
   public boolean equals(Object other)
   { 
      if (other == null) 
         return false;
      Appointment b = (Appointment)other;
      
      return description.equals(b.description) && day.equals(b.day) && from.equals(b.from) && to.equals(b.to);
   }

   /**
      Determines if an appointment falls on a certain day.
      @param d the appointment date
      @return true if the appointment date falls on a certain day
         false, otherwise
   */
   public boolean fallsOn(AppointmentDate d)
   {  
      return day.equals(d);
   }
   
   /**
      Prints the appointment.
   */
   public String print()
   { 
      return description + " " + day + " " + from + " " + to;
   }

   /**
      Returns the description of this appointment.
      @return the description of this appointment
   */
   public String getDescription()
   {
      return description;
   }

   /**
      Returns the day of this appointment.
      @return the day of this appointment
   */
   public AppointmentDate getDay()
   {
      return day;
   }

   /**
      Returns the begin time of this appointment.
      @return the begin time of this appointment
   */
   public AppointmentTime getFrom()
   {
      return from;
   }

   /**
      Returns the begin time of this appointment.
      @return the begin time of this appointment
   */
   public AppointmentTime getTo()
   {
      return to;
   }
}

