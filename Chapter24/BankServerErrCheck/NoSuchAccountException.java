//Chapter 24 - Exercise 24.4

/**
   This class is the exception that needed to be thrown when 
   there is no such an account exist in the bank.
*/
public class NoSuchAccountException extends RuntimeException
{
   /**
      Constructs the exception with a reason.
      @param reason the reason for this exception
   */
   public NoSuchAccountException(String reason)
   {
      super(reason);
   }
}