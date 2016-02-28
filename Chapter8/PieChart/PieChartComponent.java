//Chapter8 - Exercise P8.15

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
   Component that displays a pie chart.
 */
public class PieChartComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      PieChart p = new PieChart(getWidth(), getHeight());
      p.add(1.1);
      p.add(3.6);
      p.add(4.0);
      p.add(3.7);
      p.add(2.1);
      p.add(2.7);
      p.add(2.6);
      p.draw(g2);
   }
}