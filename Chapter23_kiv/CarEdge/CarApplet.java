//Chapter 23 - Exercise 23.5

import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;

public class CarApplet extends JApplet
{
	JComponent contentPane;
	protected int delay = 100;
	private CarThread car1;
	private CarThread car2;
	
	public void init()
	{
		delay = 100;
		Dimension d = getSize();
		car1 = new SmartCarThread(100, 100, 0.4, d);
		car2 = new SmartCarThread(100, 200, 0.2, d);
		car1.start();
		car2.start();
		
		contentPane = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				car1.draw((Graphics2D)g);
				car2.draw((Graphics2D)g);
			}
		};
		contentPane.setBackground(Color.green);
		setContentPane(contentPane);
	}
	
	public void update (Graphics g)
	{
		contentPane.repaint();
		repaint();
	}
	
	public void paint (Graphics g)
	{
		repaint();
	}
	
	public void stop()
	{
		car1.interrupt();
		car2.interrupt();
	}
}



















