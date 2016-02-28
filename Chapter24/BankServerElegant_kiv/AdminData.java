//Chapter 24 - Exercise 24.3

/**
   Contains bank administration data.
*/
public class AdminData
{
   private int customerCount = 0;
   private String password = "secret";
   private boolean shutdown;

   /**
      Increments the customer count.
   */
   public synchronized void incrementCustomerCount()
   {
      customerCount++;
   }

   /**
      Gets the current customer count.
   */
   public synchronized int getCustomerCount()
   {
      return customerCount;
   }

   /**
      Checks the password
      @param pw the password to check against
      @return true if this is the correct password
   */
   public synchronized boolean checkPassword(String pw)
   {
      return password.equals(pw);
   }

   /**
      Changes the password.
      @param oldPassword the current password
      @param newPassword the new password
   */
   public synchronized void changePassword(String oldPassword, String newPassword)
   {
      if (checkPassword(oldPassword))
         password = newPassword;
   }
}