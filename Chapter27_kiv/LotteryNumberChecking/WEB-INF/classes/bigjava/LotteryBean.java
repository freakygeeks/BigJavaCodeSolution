package bigjava;

import java.util.Random;
import java.util.ArrayList;

/** 
   A simple lottery bean for generating lottery numbers. 
*/
public class LotteryBean
{
    /**
       Construct a lottery bean.
    */
    public LotteryBean()
    {
        generator = new Random();
    }

    /**
       Set the maximum number of the lottery numbers.
       @param n the maximum number of the lottery numbers
    */
    public void setNumbers(int n)
    {
       numbers = n;
    }

    /**
       Set the maximum number of choices that a user can pick
       from the range of the lottery numbers.
       @param n the maximum number of choices that a user can pick
                from the range of the lottery numbers.
    */
    public void setChoices(int n)
    {
        choices = n;
    }

   /**
      Resets the user lottery numbers to an empty set.
   */
   public void reset()
   {
      error = null;
      userLotteryNumbers = new ArrayList();              
   }

    /**
       Adds to the user's lottery numbers.
       @param n the number to add
    */       
    public void add(String n)
    {
       try
       {
          Integer i = new Integer(Integer.parseInt(n));
          if (userLotteryNumbers.contains(i))
             addError("Duplicate number: " + n);
          else
             userLotteryNumbers.add(i);
       }
       catch (NumberFormatException ex)
       {
          addError("Bad input: " + n);
       }
    }


   /**
      Adds a message to the error string.
      @param msg the message to add
   */
   public void addError(String msg)
   {
      if (error == null) error = msg;
      else error = error + "\n" + msg;
   }
   /**
      Gets the error string
      @return the error string or null if no errors
   */
   public String getError()
   {
      return error;
   }

    /**
       Generates lottery numbers.
    */
    public void generateLottery()
    {
        lotteryResults = new ArrayList(choices);
        int[] values = new int[numbers];
        for (int i = 0; i < numbers; i++)
            values[i] = i + 1;
        for (int i = 0; i < choices; i++)
        {    
            int r = generator.nextInt(numbers - i);
            int c = values[r];
            values[r] = values[numbers - 1 - i];
            lotteryResults.add(new Integer(c));
        }
    }

    /**
       Count the number of matches.
       @return the number of matches.
    */
    public int getNumberOfHits()
    {
        int count = 0;
        for (int i = 0; i < userLotteryNumbers.size(); i++)
        {
            if (lotteryResults.contains(userLotteryNumbers.get(i)))
            {
                count++;
            }
        }
        return count;
    }

    /**
       Return the lottery results.
       @return the lottery results
    */
    public ArrayList getLotteryResults()
    {
        return lotteryResults;
    }

    /**
       Return user's lottery numbers.
       @return user's lottery numbers
    */
    public ArrayList getUserLotteryNum()
    {
        return userLotteryNumbers;
    }

    private ArrayList lotteryResults;
    private ArrayList userLotteryNumbers;
    private Random generator;
    private int numbers;
    private int choices;
   private String error;
}
