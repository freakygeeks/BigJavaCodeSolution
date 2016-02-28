import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
//Chapter 14 - Exercise 14.8

public class RectangleButtonPanel
{
	private Rectangle shape;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	private static final int RANDOM = 600;
	private static final int X = 0;
	private static final int Y = 0;
	private int n;
		
	public RectangleButtonPanel() 
	{
		shape = new Rectangle(X, Y, WIDTH, HEIGHT);
	}
	
	public void setNumber(int num) 
	{
		this.n = num;
	}
	
	public void paint (Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		Random gen = new Random();
		
		int x = 100;
		int y = 100;
		
		for (int i = 0; i < n; i++)
			{
			x = gen.nextInt(RANDOM);
			y = gen.nextInt(RANDOM);
			
			shape.setLocation(x, y);
			g2.draw(shape);
			}
	}
}