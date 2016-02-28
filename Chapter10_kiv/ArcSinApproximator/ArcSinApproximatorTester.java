//Chapter 10 - Exercise 10.1

import javax.swing.JOptionPane;

/**
   This class tests the ArcSinApproximator class
*/
public class ArcSinApproximatorTester
{
   public static void main(String[] args)
   {
      String input = JOptionPane.showInputDialog("x:");
      double x = Double.parseDouble(input);

      ArcSinApproximator as = new ArcSinApproximator(x);

      System.out.println("arcsin: " + as.getArcSin());

      System.exit(0);
   }
}
