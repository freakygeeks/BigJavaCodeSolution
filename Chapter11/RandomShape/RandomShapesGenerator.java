//Chapter11 - Exercise P11.12

import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Arc2D;

public class RandomShapesGenerator
{
	private int xLeft;
	private int yTop;
	private Random gen = new Random();

	public RandomShapesGenerator(int x, int y)
	{
	xLeft = x;
	yTop = y;
	}
	
	public Shape randomShape()
	{
	
	int aX = gen.nextInt(xLeft);
	int aY = gen.nextInt(yTop);
	
	Shape rect1 = new Rectangle2D.Double (aX, aY, 200, 200);
	Shape rect2 = new Rectangle2D.Double (aX, aY, 100, 100);
	Shape oval1 = new Ellipse2D.Double (aX, aY, 200, 200);
	Shape oval2 = new Ellipse2D.Double (aX, aY, 100, 100);
	Shape line1 = new Line2D.Double (aX, aY, 200, 200);
	Shape line2 = new Line2D.Double (aX, aY, 100, 100);
	Shape cubic = new CubicCurve2D.Double(aX,aY,100,-100,-200,-100,200,100);
	Shape arc = new Arc2D.Double(50, 50, 300, 300, 0, 90, Arc2D.PIE);
	
	switch(gen.nextInt(10))
		{
		default :
		case 0 : return rect1;
		case 1 : return rect2;
		case 2 : return oval1;
		case 3 : return oval2;
		case 4 : return line1;
		case 5 : return line2;
		case 6 : return cubic;
		case 7 : return arc;
		}
	}
}

