package bigjava;

import java.text.DateFormat;
import java.util.Date;
import java.util.*;
import java.sql.*;
/**
   This bean formats the local times of day for a given date
   and list of cities.
*/
public class MultiZoneBean
{
   /**
      Initializes the formatter and city list.
   */
   public MultiZoneBean()
   {
      timeFormatter = DateFormat.getTimeInstance();
      cities = new HashSet();
   }


   /**
      Sets the current user
      @param: aUser the current user
   */
   public void setUser(String aUser)
   {
       user=aUser;
   }

   /**
      Returns the current user
   */
   public String getUser()
   {
       return user;
   }

   /**
      Sets the password of the current user
      @param: aPwd the password
   */
   public void setPwd(String aPwd)
   {
       pwd=aPwd;
   }

   /**
      Returns the passward
   */
   public String getPwd()
   {
       return pwd;
   }


   /**
      Write-only date property.
      @param aDate the date to be formatted.
   */
   public void setDate(Date aDate)
   {
       theDate = aDate;
   }


   /**
      Write-only city property.
      @param aCity the city to add to the city list
   */
   public void setCity(String aCity) throws SQLException
   {
       findCities();
       int flag=0;
       Iterator iter = cities.iterator();
       while(iter.hasNext())
       {
           String city =(String)iter.next();
           if(city.equals(aCity))
           {
               flag=1;
           }
       }

       if(flag==0)
       {
           Connection conn = null;
           try
           {
               conn = DataSourceBean.getConnection();
               Statement stat = conn.createStatement();
               String query = "INSERT INTO FavorCities VALUES ('" + user + "','" + pwd + "','" + aCity +"')";
               stat.execute(query);
           }
           finally
           {
               if (conn != null) conn.close();
           }
       }
       cities = new HashSet();
   }

    /**
       The city property.
       @return the city for which to report the local time
    */
    public void findCities() throws SQLException
    {
        Connection conn = null;
        try
        {
            conn = DataSourceBean.getConnection();
            Statement stat = conn.createStatement();
            String query = "SELECT * FROM favorCities"
                + " WHERE userID = '" + user + "' AND password = '" + pwd + "'";
            ResultSet result = stat.executeQuery(query);
            while (result.next())
            {
                cities.add(result.getString("city"));
            }
        }
        finally
        {
            if (conn != null) conn.close();
        }
    }

   /**
      Checks the authority of the user
   */
   public boolean getMatch() throws SQLException
   {
       Connection conn = null;
       try
       {
           conn = DataSourceBean.getConnection();
           Statement stat = conn.createStatement();
           String query = "SELECT * FROM favorCities"
               + " WHERE userID = '" + user + "' AND password = '" + pwd + "'";
           ResultSet result = stat.executeQuery(query);
           if (result.next())
           {
               return true;
           }
           else
               return false;
       }
       finally
       {
           if (conn != null) conn.close();
       }
   }

   /**
      Read-only times property.
      @return a string containing the HTML code for table rows with cities and local times
   */
   public String getTimes() throws SQLException
   {
      Connection conn = null;
      try
      {
         conn = DataSourceBean.getConnection();
         Statement stat = conn.createStatement();
         String query = "SELECT city FROM favorCities"
            + " WHERE userID = '" + user + "' AND password = '" + pwd + "'";
         ResultSet result = stat.executeQuery(query);


         StringBuffer buffer = new StringBuffer();
         while (result.next())
         {
            String city = ((String)result.getString(1)).trim();

            buffer.append("<li>");
            buffer.append(city);
            buffer.append(": ");
            
            TimeZone zone = getTimeZone(city);
            if (zone == null) 
               buffer.append("not available");
            else
            { 
               timeFormatter.setTimeZone(zone);
               String timeString = timeFormatter.format(theDate);
               buffer.append(timeString);
            }
            buffer.append("</li>");            
         }
         return buffer.toString();
      }
      finally
      {
         if (conn != null) conn.close();
      }
   }

   /**
      Looks up the time zone for a city
      @param aCity the city for which to find the time zone
      @return the time zone or null if no match is found
   */
   public static TimeZone getTimeZone(String city)
   {
      String[] ids = TimeZone.getAvailableIDs();
      for (int i = 0; i < ids.length; i++)
         if (timeZoneIDmatch(ids[i], city))
            return TimeZone.getTimeZone(ids[i]);
      return null;
   }

   /**
      Checks whether a time zone ID matches a city
      @param id the time zone ID (e.g. "America/Los_Angeles")
      @param aCity the city to match (e.g. "Los Angeles")
      @return true if the ID and city match
   */
   public static boolean timeZoneIDmatch(String id, String city)
   {
      String idCity = id.substring(id.indexOf('/') + 1);
      return idCity.replace('_', ' ').equals(city);
   }

   private DateFormat timeFormatter;
   private Date theDate;
   private String user;
   private String pwd;
   private String city;
   private Set cities;

}
