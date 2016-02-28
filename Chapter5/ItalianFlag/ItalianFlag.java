//Chapter5 - Example How To 5.1
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;

public class ItalianFlag
{
	private double xLeft;
	private double yTop;
	private double width;

	public ItalianFlag (double x, double y, double aWidth)
	{
	xLeft = x;
	yTop = y;
	width = aWidth;
	}
	
	public void draw (Graphics2D g2)
	{
	Rectangle leftRec = new Rectangle (100, 100, 30, 60); 
	Rectangle rightRec = new Rectangle (160, 100, 30, 60);
	Line2D.Double topLine = new Line2D.Double (130, 100, 160, 100);
	Line2D.Double downLine = new Line2D.Double (130, 160, 160, 160);
	
	/*
	Rectangle leftRec = new Rectangle (xLeft, yTop, width/3, width*2/3);
	Rectangle rightRec = new Rectangle (xLeft + width*2/3, yTop, width/3, width*2/3);
	Line2D.Double topLine = new Line2D.Double (xLeft + width/3, yTop, xLeft + width*2/3, yTop);
	Line2D.Double downLine = new Line2D.Double (xLet + width/3, yTop + width*2/3, xLeft + width*2/3; yTop + width*2/3);	
	*/
	
	g2.setColor(Color.GREEN);
	g2.fill(leftRec);
	g2.setColor(Color.RED);
	g2.fill(rightRec);
	g2.setColor(Color.BLACK);
	g2.draw(topLine);
	g2.draw(downLine);
	}
}