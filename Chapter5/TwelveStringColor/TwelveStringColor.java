//Chapter5 - Exercise P5.3
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class TwelveStringColor extends JComponent
{
	/*private double xTop;
	private double yLetf;
	private double aWidth;
	
	public TwelveStringColor (double x, double y, double width)
	{
	xTop = x;
	yLeft = y;
	aWidth = width;
	}*/
	
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Line2D.Double black = new Line2D.Double (100, 100, 300, 100);
	Line2D.Double blue = new Line2D.Double (100, 110, 300, 110);
	Line2D.Double cyan = new Line2D.Double (100, 120, 300, 120);
	Line2D.Double gray = new Line2D.Double (100, 130, 300, 130);
	Line2D.Double darkgray = new Line2D.Double (100, 140, 300, 140);
	Line2D.Double lightgray = new Line2D.Double (100, 150, 300, 150);
	Line2D.Double green = new Line2D.Double (100, 160, 300, 160);
	Line2D.Double magenta = new Line2D.Double (100, 170, 300, 170);
	Line2D.Double orange = new Line2D.Double (100, 180, 300, 180);
	Line2D.Double pink = new Line2D.Double (100, 190, 300, 190);
	Line2D.Double red = new Line2D.Double (100, 200, 300, 200);
	Line2D.Double yellow = new Line2D.Double (100, 210, 300, 210);
	
	g2.setColor(Color.BLACK);
	g2.draw(black);
	g2.setColor(Color.BLUE);
	g2.draw(blue);
	g2.setColor(Color.CYAN);
	g2.draw(cyan);
	g2.setColor(Color.GRAY);
	g2.draw(gray);
	g2.setColor(Color.DARK_GRAY);
	g2.draw(darkgray);
	g2.setColor(Color.LIGHT_GRAY);
	g2.draw(lightgray);
	g2.setColor(Color.GREEN);
	g2.draw(green);
	g2.setColor(Color.MAGENTA);
	g2.draw(magenta);
	g2.setColor(Color.ORANGE);
	g2.draw(orange);
	g2.setColor(Color.PINK);
	g2.draw(pink);
	g2.setColor(Color.RED);
	g2.draw(red);
	g2.setColor(Color.YELLOW);
	g2.draw(yellow);
	}
}
	
	