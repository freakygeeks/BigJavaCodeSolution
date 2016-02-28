//Chapter5 - Example 5.5 & Exercise P5.16
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;

public class Car
{
	public static int WIDTH = 60*3;
	public static int HEIGHT = 30*3;
	private int xLeft;
	private int yTop;
	private Color fillColor;
	
	public Car(int x, int y, Color aColor)
	{
	xLeft = x; //x coordinate of the top-left corner
	yTop = y; //y coordinate of the top-left corner
	fillColor = aColor;
	}
	
	public void draw(Graphics2D g3)
	{
	Rectangle body = new Rectangle(xLeft, yTop + 10*3, 60*3, 10*3); //car body rectangle
	Ellipse2D.Double frontTyre = new Ellipse2D.Double (xLeft + 10*3, yTop + 20*3, 10*3, 10*3); //front tyre circle
	Ellipse2D.Double rearTyre = new Ellipse2D.Double (xLeft + 40*3, yTop + 20*3, 10*3, 10*3); //rear tyre circle
	
	Point2D.Double r1 = new Point2D.Double (xLeft + 10*3, yTop + 10*3);
	Point2D.Double r2 = new Point2D.Double (xLeft + 20*3, yTop);
	Point2D.Double r3 = new Point2D.Double (xLeft + 40*3, yTop);
	Point2D.Double r4 = new Point2D.Double (xLeft + 50*3, yTop + 10*3);
	
	Line2D.Double frontWindshield = new Line2D.Double(r1,r2);
	Line2D.Double roofTop = new Line2D.Double (r2,r3);
	Line2D.Double rearWindshield = new Line2D.Double (r3,r4);
	
	g3.draw(body);
	g3.setColor(fillColor);
	g3.fill(body);
	g3.draw(frontTyre);
	g3.draw(rearTyre);
	g3.draw(frontWindshield);
	g3.draw(roofTop);
	g3.draw(rearWindshield);
	}
}
	
	
	