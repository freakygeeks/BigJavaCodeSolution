//Chapter 26 - Project 26.1

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
   An appointment date.
*/
public class AppointmentDate
{  
   private int year;
   private int month;
   private int day;
   
   public AppointmentDate(String d)
   {  
      StringTokenizer tokenizer = new StringTokenizer(d, "/");
      year = Integer.parseInt(tokenizer.nextToken());
      month = Integer.parseInt(tokenizer.nextToken());
      day = Integer.parseInt(tokenizer.nextToken());
   }

   /**
      Determines if dates are equal.
      @param the other date
      @return true if the dates are equal, false otherwise
   */
   public boolean equals(Object other)
   { 
      if (other == null) return false;
      AppointmentDate b = (AppointmentDate)other;
      return year == b.year && month == b.month && day == b.day;
   }
   
   /**
      Prints a string representation of the date.
      @return the date
   */
   public String toString()
   { 
      return year + "/" + month + "/" + day;
   }
}

