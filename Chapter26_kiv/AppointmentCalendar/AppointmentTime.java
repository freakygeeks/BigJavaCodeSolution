//Chapter 26 - Project 26.1

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
   An appointment time.
*/
public class AppointmentTime
{ 
   private int hours;
   private int minutes;
   
   public AppointmentTime(String t)
   {  
      StringTokenizer tokenizer = new StringTokenizer(t, ":");
      hours = Integer.parseInt(tokenizer.nextToken());
      minutes = Integer.parseInt(tokenizer.nextToken());
   }

   /**
      Determines if the appointment times are equal.
      @param other the other time
      @return true if the appointment times are equal, false otherwise
   */
   public boolean equals(Object other)
   { 
      if (other == null) 
         return false;
      AppointmentTime b = (AppointmentTime)other;
      return hours == b.hours && minutes == b.minutes;
   }

   /**
      Prints a string representation of the time.
      @return the time
   */
   public String toString()
   {  
      String r = hours + ":";
      if (minutes < 10) r = r + "0";
      r = r + minutes;
      return r;
   }
}

