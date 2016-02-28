//Chapter 27 - Example 27.2

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
   This bean formats the local time of day for a given date
   and city.
*/
public class TimeZoneBean
{
	private DateFormat timeFormatter;
    private String city;
    private TimeZone zone;
	
	
   /**
      Initializes the formatter.
   */
   public TimeZoneBean()
   {
      timeFormatter = DateFormat.getTimeInstance();
   }

   /**
      Setter for city property.
      @param aCity the city for which to report the local time
   */
   public void setCity(String aCity)
   {      
      city = aCity;
      zone = getTimeZone(city);
   }
   
   /**
      Getter for city property.
      @return the city for which to report the local time
   */
   public String getCity()
   {
      return city;
   }

   /**
      Read-only time property.
      @return the formatted time
   */
   public String getTime()
   {
      if (zone == null) return "not available";
      timeFormatter.setTimeZone(zone);
      Date time = new Date();
      String timeString = timeFormatter.format(time);
      return timeString;
   }

   /**
      Looks up the time zone for a city.
      @param aCity the city for which to find the time zone
      @return the time zone or null if no match is found
   */
   private static TimeZone getTimeZone(String city)
   {
      String[] ids = TimeZone.getAvailableIDs();
      for (int i = 0; i < ids.length; i++)
         if (timeZoneIDmatch(ids[i], city))
            return TimeZone.getTimeZone(ids[i]);
      return null;
   }

   /**
      Checks whether a time zone ID matches a city.
      @param id the time zone ID (e.g. "America/Los_Angeles")
      @param aCity the city to match (e.g. "Los Angeles")
      @return true if the ID and city match
   */
   private static boolean timeZoneIDmatch(String id, String city)
   {
      String idCity = id.substring(id.indexOf('/') + 1);
      return idCity.replace('_', ' ').equals(city);
   }
}
