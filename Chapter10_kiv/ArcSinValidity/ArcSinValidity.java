//Chapter 10 - Exercise 10.5

/**
   This class provides methods to compute the
      arcsin of a number
*/
public class ArcSinValidity
{
   public static final double EPS = 0.000001;

   private double x;
   private double term;
   private double total;
   private int i;
   
   /**
      Constructs an ArcSinApproximator object
      @param anX the number to compute
         the arcsin
   */
   public ArcSinValidity(double anX)
   {
      x = anX;
      term = x;
      total = x;
      i = 3;      
   }

   /**
      Determine the next closest guess to the arcsin
      @return total the next closest approximation
         to the arcsin
   */
   public double nextGuess()
   {    
      term = term * x * x * (i - 2) * (i - 2) / ((i - 1) * i);
      total = total + term;
      i = i + 2;  
      
      return total;
   }
  
   /**
      Get the arcsin of a number
      @return total the arcsin
   */
   public double getArcSin()
   {
      while (Math.abs(term) > EPS)
         nextGuess();
      return total;
   }
}
