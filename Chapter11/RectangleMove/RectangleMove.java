//Chapter11 - Exercise P11.14

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.Date;
import javax.swing.JComponent;

public class RectangleMove extends JComponent
{
	private Rectangle rect;
	
	public RectangleMove()
	{
		rect = new Rectangle(100, 100);
   
		class RectangleTimer implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				rect = new Rectangle (150, 150);
				rect = new Rectangle (300, 300);
			}
		}

		RectangleTimer listener = new RectangleTimer();

		final int DELAY = 100; // milliseconds between timer ticks
		Timer t1 = new Timer(DELAY, listener);
		t1.start();
	}
	
	public void paint (Graphics g)
	{
		final Graphics2D g2 = (Graphics2D) g;
		rect.draw(g2);
	}  
}