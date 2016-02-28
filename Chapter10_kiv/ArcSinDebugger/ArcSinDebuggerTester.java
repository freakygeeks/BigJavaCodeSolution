//Chapter 10 - Exercise 10.11

import javax.swing.JOptionPane;

/**
   This class test the ArcSinApproximator class
*/
public class ArcSinDebuggerTester
{
   public static void main(String[] args)
   {
      String input = JOptionPane.showInputDialog(
         "x:");
      double x = Double.parseDouble(input);
      ArcSinDebugger as = new ArcSinDebugger(x);
      System.out.println("arcsin: " + as.getArcSin());

      System.exit(0);
   }
}
