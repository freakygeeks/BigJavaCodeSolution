//Chapter5 - Exercise P5.1
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Name
{
	private int xLeft;
	private int yTop;
	
	public Name (int x, int y)
	{
	xLeft = x;
	yTop = y;
	}
	
	public void draw (Graphics2D g2)
	{
	Rectangle rect = new Rectangle (xLeft, yTop + 100, 200, 100);
	g2.setColor(Color.BLUE);
	g2.draw(rect);
	g2.setColor(Color.RED);
	g2.drawString("NIESE",125, 200);
	}
}