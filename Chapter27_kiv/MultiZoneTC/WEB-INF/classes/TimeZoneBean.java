//Chapter 27 - Example 27.5

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
   This bean formats the local time of day for a given date
   and city.
*/
public class TimeZoneBean
{
	
   private DateFormat timeFormatter;
   private ArrayList<String> cities;
   private String city;
   private TimeZone zone;
   private String cityToRemove;
   
   /**
      Initializes the formatter.
   */
   public TimeZoneBean()
   {
      timeFormatter = DateFormat.getTimeInstance();
      cities = new ArrayList<String>();
   }

   /**
      Setter for city property.
      @param aCity the city to add to the list of cities
   */
   public void setCity(String aCity)
   {      
      city = aCity;
      zone = getTimeZone(city);
   }
   
   /**
      Getter for city property.
      @return the city to add to the list of cities
   */
   public String getCity()
   {
      return city;
   }
   
   /**
      Setter for the cityToRemove property.
      @param aCity the city to remove
   */
   public void setCityToRemove(String aCity) 
   {      
      cityToRemove = aCity;
   }

   /**
      Getter for the cityToRemove property.
      @return the empty string
   */
   public String getCityToRemove() 
   {      
      return cityToRemove;
   }
   
   /**
      Read-only citiesAndTimes property.
      @return a map containing the cities and formatted times
   */
   public Map<String, String> getCitiesAndTimes()
   {
      Date time = new Date();
      Map<String, String> result = new TreeMap<String, String>();
      for (int i = 0; i < cities.size(); i++)
      {
         String city = cities.get(i);
         String label = city + ": ";
         TimeZone zone = getTimeZone(city);
         if (zone != null)
         {
            timeFormatter.setTimeZone(zone);
            String timeString = timeFormatter.format(time);
            label = label + timeString;            
         }
         else 
            label = label + "unavailable";            
         result.put(label, city);
      }

      return result;
   }

   /**
      Action for adding a city.
      @return "available" if time zone information is available for the city,
      "unavailable" otherwise
   */
   public String addCity()
   {
      if (zone == null) return "unavailable";
      cities.add(city);
      cityToRemove = city;
      city = "";
      return "available";
   }

   /**
      Action for removing a city.
      @return null if there are more cities to remove, "back" otherwise
   */
   public String removeCity()
   {
      cities.remove(cityToRemove);
      if (cities.size() > 0) return null;
      else return "back";
   }
   
   /**
      Looks up the time zone for a city
      @param aCity the city for which to find the time zone
      @return the time zone or null if no match is found
   */
   private static TimeZone getTimeZone(String city)
   {
      String[] ids = TimeZone.getAvailableIDs();
      for (int i = 0; i < ids.length; i++)
         if (timeZoneIDmatch(ids[i], city))
            return TimeZone.getTimeZone(ids[i]);
      try
      {
         String id = getZoneNameFromDB(city);
         if (id != null)
            return TimeZone.getTimeZone(id);
      }
      catch (Exception exception)
      {
		  exception.printStackTrace();
		  
         /*Logger.global.info("Caught in TimeZone.getTimeZone: " 
               + exception.printStackTrace());*/
      }
      return null;
   }

   private static String getZoneNameFromDB(String city) 
      throws NamingException, SQLException
   {
      InitialContext ctx = new InitialContext();
      DataSource source 
         = (DataSource) ctx.lookup("java:/comp/env/jdbc/mydb");
      Connection conn = source.getConnection();
      try
      {
         PreparedStatement stat = conn.prepareStatement(
            "SELECT Zone FROM CityZone WHERE City=?");
         stat.setString(1, city);
         ResultSet result = stat.executeQuery();
         if (result.next()) 
            return result.getString(1);
         else
            return null;
      }
      finally
      {
         conn.close();
      }
   }

   /**
      Checks whether a time zone ID matches a city
      @param id the time zone ID (e.g. "America/Los_Angeles")
      @param city the city to match (e.g. "Los Angeles")
      @return true if the ID and city match
   */
   private static boolean timeZoneIDmatch(String id, String city)
   {
      String idCity = id.substring(id.indexOf('/') + 1);
      return idCity.replace('_', ' ').equals(city);
   }
}
