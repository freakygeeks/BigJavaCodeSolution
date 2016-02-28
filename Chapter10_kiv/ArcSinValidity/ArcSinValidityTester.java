//Chapter 10 - Exercise 10.5

import java.util.Random;

/**
   This class tests the ArcSinApproximator class by verifying
      Math.sin(new ArcSinApproximator(x).getArcSin())
      is approximately equal to x
*/
public class ArcSinValidityTester
{
   public static void main(String[] args)
   {
      int i;
      Random generator = new Random();
      for (i = 1; i < 100; i++)
      {
         final double EPS = 0.000001;
         double x = -1 + 2 * generator.nextDouble();
         ArcSinValidity as = new ArcSinValidity(x);
         double y = as.getArcSin();
         double z = Math.sin(y);

         if (Math.abs(x - z) <= EPS) /* this is too tight--it will fail for some inputs */
            System.out.print("Test passed. ");
         else System.out.print("Test failed. ");

         System.out.println("arc sine of " + x + " = " + y + ", sine is " + z);
      }
   }
}
