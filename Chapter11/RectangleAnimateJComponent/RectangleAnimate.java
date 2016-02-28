//Chapter11 - Exercise P11.15

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JComponent;

public class RectangleAnimate extends JComponent
{
	private Rectangle rect;
	private int x;
	private int y;
	
	public RectangleAnimate()
	{
		x = 100;
		y = 100;
		rect = new Rectangle (x, y);
	
		class RectangleMover implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				rect = new Rectangle(x,y);
				x++;
				y++;
				repaint();
			
			}
		}
	
		RectangleMover listener = new RectangleMover();
	
		final int DELAY = 100;
		Timer t = new Timer (DELAY, listener);
		t.start();
	}
	
	public void paint (Graphics g)
	{
		final Graphics2D g2 = (Graphics2D) g;
		rect.draw(g2);
	}

}