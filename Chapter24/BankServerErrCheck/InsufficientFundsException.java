//Chapter 24 - Exercise 24.4

/**
   This class is the exception that needed to be thrown when 
   there is insufficient funds in an account.
*/
public class InsufficientFundsException extends RuntimeException
{
   /**
      Constructs the exception with a reason.
      @param reason the reason for this exception
   */
   public InsufficientFundsException(String reason)
   {
      super(reason);
   }
}