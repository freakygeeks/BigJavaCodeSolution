//Chapter 12 - Project 12.2

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   This class provides a method a draw a regression line
*/
public class RegressionLine
{	   
   private int n;
   private int width;
   private double sum_x;
   private double sum_y;
   private double sum_xx;
   private double sum_xy;   

   /**
      Construct a RegressionLine object
      @param n the count of input values
      @param aWidth the width of the applet
      @param aSum_x the sum of x
      @param aSum_y the sum of y
      @param aSum_xx the sum of x * x
      @param aSum_xy the sum of x * y
   */
   public void setVariable (int aNum, int aWidth, double aSum_x, double aSum_y, double aSum_xx, double aSum_xy)
   {
      n = aNum;
      width = aWidth;      
      sum_x = aSum_x;
      sum_y = aSum_y;
      sum_xx = aSum_xx;
      sum_xy = aSum_xy;
   }
   
   /**
      Draws a regression line
      @param g2 the graphics context
   */
   //public void draw(Graphics2D g2)
   public void paint (Graphics g)
   {
		Graphics2D g2 = (Graphics2D) g;
		
		if (n == 0) return;
		double xAvg = sum_x / n;
		double yAvg = sum_y / n;
		double m;
      
		if (n == 1)
			{
				m = 0;
			}
		else
			{
				m = (sum_xy - n * xAvg * yAvg) / (sum_xx - n * xAvg * xAvg);
			}
		
		double y1 = yAvg - m * xAvg;
		double x2 = width;
		double y2 = yAvg + m * (x2 - xAvg);
	  
		g2.draw(new Line2D.Double(new Point2D.Double(0, y1),new Point2D.Double(x2, y2)));      
   }
}

