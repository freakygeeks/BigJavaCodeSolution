//Chapter 26 - Exercise 26.11

import java.util.ArrayList;
import java.awt.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;

public class DrawPanel extends JPanel
{
	private ArrayList objectList;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public DrawPanel(ArrayList aList)
	{
		objectList = aList;
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		for (int i = 0; i < objectList.size(); i++)
		{
			Object drawingObject = objectList.get(i);
			
			if (drawingObject instanceof Shape)
			{
				g2.draw((Shape)drawingObject);
			}
			else if (drawingObject instanceof Message)
			{
				Message msg = (Message)drawingObject;
				g2.drawString(msg.getText(), msg.getX(), msg.getY());
			}
		}
	}
}
















