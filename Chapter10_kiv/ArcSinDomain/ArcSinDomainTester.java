//Chapter 10 - Exercise 10.7

import javax.swing.JOptionPane;

/**
   This class test the ArcSinApproximator class
   If the input x is (x < -1 || x > 1), the test fails.
   (x < -1 || x > 1) is the domain of the arc sine function
*/
public class ArcSinDomainTester
{
   public static void main(String[] args)
   {
      String input = JOptionPane.showInputDialog(
         "x:");
      double x = Double.parseDouble(input);

      ArcSinDomain as = new ArcSinDomain(x);

      System.out.println("arcsin: " + as.getArcSin());

      System.exit(0);
   }
}
