//Chapter 10 - Exercise 10.3

/**
   This test class automatically generates test cases for
      the ArcSinApproximator class.
*/
public class ArcSinStepSizeTester
{
   public static void main(String[] args)
   {
      double x;
      for (x = -1; x <= 1; x = x + 0.1)
      {
         ArcSinStepSize as = new ArcSinStepSize(x);
         double y = as.getArcSin();
         System.out.println("arc sine of " + x + " = " + y);
      }
   }
}
