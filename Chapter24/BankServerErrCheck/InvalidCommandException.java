//Chapter 24 - Exercise 24.4

/**
   This class is the exception that needed to be thrown when 
   there is invalid command in the Simple Bank Access Protocol.
*/
public class InvalidCommandException extends RuntimeException
{
   /**
      Constructs the exception with a reason.
      @param reason the reason for this exception
   */
   public InvalidCommandException(String reason)
   {
      super(reason);
   }
}