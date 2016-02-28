//Chapter8 - Exercise P8.13

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
 
public class BarChart extends JComponent
{
   private int width;
   private int height;
   private ArrayList<Double> data;//create arraylist type double for barchart value
 
   public BarChart(int aWidth, int aHeight)
   {
      width = aWidth;
      height = aHeight;
      data = new ArrayList<Double>();//define new object for arraylist
   }
 
   public void add(double value)//input for barchart length
   {
      data.add(value);//append barchart length value to arraylist
   }
 
   public void draw(Graphics2D g2)
   {
      int i = 0;
      double max = 0;//start of y1
 
      for (Double wrapper : data) //for each value input data wrapper in arraylist data
         if(max < wrapper)
            max = wrapper;
 
      int xwidth = width - 1;
      int yheight = height - 1;
 
      int xleft = 0;
 
      for (i = 0; i < data.size(); i++)
      {
         int xright = xwidth * (i + 1) / data.size();//to get the x1 for the next barchart
         int barWidth = xwidth / data.size();//to get the average value of width for each arraylist element
         int barHeight = (int) Math.round(yheight * data.get(i) / max);//to get the height of barchart in arraylist
 
         Rectangle bar = new Rectangle(xleft, yheight - barHeight, barWidth, barHeight);
         g2.draw(bar);//draw the chart
         xleft = xright;//next value of x1 for next barchart
      }
   }
}