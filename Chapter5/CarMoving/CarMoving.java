//Chapter5 - Exercise P5.15
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import javax.swing.JComponent;

public class CarMoving extends JComponent
{
	public static int WIDTH = 60;
	public static int HEIGHT = 30;
	private int xLeft;
	private int yTop;
	private Color fillColor;
	
	public CarMoving (int x, int y, Color aColor)
	{
	xLeft = x;
	yTop = y;
	fillColor = aColor;	
	}
		
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
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
	
	g2.translate(10,10);
	g2.translate(30,30);
	g2.draw(body);
	g2.setColor(fillColor);
	g2.fill(body);
	g2.draw(frontTyre);
	g2.draw(rearTyre);
	g2.draw(frontWindshield);
	g2.draw(roofTop);
	g2.draw(rearWindshield);
	
	}
}