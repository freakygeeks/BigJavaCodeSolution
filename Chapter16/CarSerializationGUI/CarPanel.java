//Chapter 16 - Project 16.1

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class CarPanel extends JPanel implements Serializable //get the mouse input and draw the car shape
{
	private CarData data;
	private final int WIDTH = 300;
	private final int HEIGHT = 300;
	
	public CarPanel()
	{
		data = new CarData();
		setPreferredSize(new Dimension (WIDTH, HEIGHT));
		
		class ClickListener extends MouseAdapter
		{
			public void mouseClicked(MouseEvent event)
			{
				int x = event.getX();
				int y = event.getY();
				data.add(x, y);
				repaint();
			}
		};
		
		addMouseListener(new ClickListener());
	}
	
	public CarData getCarData()
	{
		return data;
	}
	
	public void setCarData(CarData d)
	{
		data = d;
		repaint();
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < data.size(); i++)
		{
			Car c = data.get(i);
			c.draw(g2);
		}
	}
}









































