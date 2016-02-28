//Chapter11 - Exercise P11.12

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class RandomShapesComponent extends JComponent
{ 

	public void paintComponent(Graphics g)
    {
		Graphics2D g2 = (Graphics2D) g;
		
		RandomShapesGenerator r = new RandomShapesGenerator(getWidth(),getHeight());
		
		for (int i = 1; i <= 10; i++)
		{
			g2.draw(r.randomShape());
		}
    }
}