package bigjava;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
   A simple data source bean for getting database connections.
*/
public class DataSourceBean
{
   /**
      Write-only driver property.
      @param driver the database driver name
   */
   public void setDriver(String driver)
      throws ClassNotFoundException
   {
      Class.forName(driver);
   }

   /**
      Write-only url property.
      @param aUrl the JDBC URL
   */
   public void setUrl(String aUrl)
   {
      url = aUrl;
   }

   /**
      Write-only username property.
      @param aUsername the database user name
   */
   public void setUsername(String aUsername)
   {
      username = aUsername;
   }

   /**
      Write-only password property.
      @param aUsername the database user's password
   */
   public void setPassword(String aPassword)
   {
      password = aPassword;
   }

   /**
      Gets a connection to the database.
      @return the database connection
   */
   public static Connection getConnection()
      throws SQLException
   {
      return
         DriverManager.getConnection(url, username, password);
   }

   private static String url;
   private static String username;
   private static String password;
}
