//Chapter 12 - Project 12.1

/**
   A purse computes the total value of a collection of coins.
*/
public class Purse
{
   /**
      Constructs an empty purse.
   */
   public Purse()
   {
      total = 0;
   }

   /**
      Add a coin to the purse.
      @param aCoin the coin to add
   */
   public void add(Coin aCoin)
   {
      total = total + aCoin.getValue();
   }

   /**
      Get the total value of the coins in the purse.
      @return the sum of all coin values
   */
   public double getTotal()
   {
      return total;
   }

   private double total;
}
