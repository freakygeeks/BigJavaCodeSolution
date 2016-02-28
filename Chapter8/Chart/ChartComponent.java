//Chapter8 - Exercise P8.12

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ChartComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      Chart c = new Chart(getWidth(), getHeight());
      c.add(10);
      c.add(30);
      c.add(80);
      c.add(30);
      c.add(20);
      c.add(200);
      c.add(100);      

      c.draw(g2);
   }
}