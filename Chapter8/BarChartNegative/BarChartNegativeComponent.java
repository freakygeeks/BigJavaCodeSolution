//Chapter8 - Exercise P8.14

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
public class BarChartNegativeComponent extends JComponent
{
	public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      BarChartNegative c = new BarChartNegative(getWidth(), getHeight());
      c.add(1);
      c.add(-3.3);
      c.add(4.0);
      c.add(3.7);
      c.add(-2.1);
      c.add(2.7);
      c.add(2.6);
      c.draw(g2);
   }
}