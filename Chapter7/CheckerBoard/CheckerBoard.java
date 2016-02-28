//Chapter7 - Exercise P7.7 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JComponent;

public class CheckerBoard extends JComponent
{
	private int x;
	private int y;
	private int p;
	private int row;
	private int col;
	
	CheckerBoard()
	{
	x = 0;
	y = 0;
	p = 50; //space between each of x and y
	row = 0; //8 row for checkerboard
	col = 0; //8 col for checkerboard
	}
	
	public void paintComponent(Graphics g)
	{
	final int WIDTH = 50;
	final int HEIGHT = 50;
	
	Graphics2D g2 = (Graphics2D) g;
	
	for (row = 0; row < 8; row++)
		{
		for (col = 0; col < 8; col++)
			{
			int x = col*p;
			int y = row*p;
			
			if ((col%2) == (row%2))
				{
				g2.setColor(Color.WHITE);
				}
			else
				{
				g2.setColor(Color.BLACK);
				}
				Rectangle board = new Rectangle (x, y, WIDTH, HEIGHT);
				g2.fill(board);
			}
		}
	}
}