//Chapter 12 - Project 12.2

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegressionLineViewer extends Applet
{  
   public RegressionLineViewer()
   {  
      sum_x = 0;
      sum_y = 0;
      sum_xx = 0;
      sum_xy = 0;
      n = 0;

      // add mouse click listener

      MouseClickListener listener = new MouseClickListener();
      addMouseListener(listener);
   }

   public void paint(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D)g;
      RegressionLine rl = new RegressionLine(n, getWidth(), sum_x, sum_y, sum_xx, sum_xy);
      rl.draw(g2);
   }

   // implement the mouse press handler
   
   class MouseClickListener extends MouseAdapter
   {  
      public void mousePressed(MouseEvent event)
      {  
         int mouseX = event.getX();
         int mouseY = event.getY();
         sum_x += mouseX;
         sum_y += mouseY;
         sum_xx += mouseX * mouseX;
         sum_xy += mouseX * mouseY;
         n++;
         repaint();
      }
   }
   
   private int n;
   private double sum_x;
   private double sum_y;
   private double sum_xx;
   private double sum_xy;
}
