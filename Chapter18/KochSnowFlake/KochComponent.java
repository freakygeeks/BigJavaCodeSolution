//Chapter 18 - Exercise P18.15
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch13/c13_exp_13_15
//http://www.math.ubc.ca/~cass/courses/m308/projects/fung/page.html
//http://meandering-through-mathematics.blogspot.com/2011/09/koch-snowflakes.html
//http://aisha91.hubpages.com/hub/Java-Source-Code-Recursive-Snow-Flakes
//https://www.daniweb.com/software-development/java/threads/135591/koch-snowflake/2

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;
import java.awt.Polygon;

public class KochComponent extends  JComponent
{
	private int numIterations;
	private ArrayList<Integer> x;
	private ArrayList<Integer> y;
	private GeneralPath path;
	private int vertex;
	private int[] xPoint;
	private int[] yPoint;
	private Polygon koch;
	
	public KochComponent()
	{
		numIterations = 1;
		x = new ArrayList<Integer>();
		y = new ArrayList<Integer>();
	}
	
	public void next()
	{
		numIterations++;
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		int length = Math.min(getWidth(), getHeight())*2/3;
		
		int xA = 10;
		int yA = length/2;
		int xB = xA + length;
		int yB = yA;
		int xC = xA + (length/2);
		int yC = yA + length;
		
		draw(g2, numIterations, xA, yA, xB, yB);
		draw(g2, numIterations, xB, yB, xC, yC);
		draw(g2, numIterations, xC, yC, xA, yA);
	}
	
	//to do
	private void draw (Graphics2D g2, int iteration, double x1, double y1, double x2, double y2)
	{
		x.add((int)x1);
		x.add((int)x2);
		y.add((int)y1);
		y.add((int)y2);
		
		double n = 3*Math.pow(4, iteration-1);
		vertex = (int)n;		
	}
	
	public void paint (Graphics g)
	{
		paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		
		Object[] xObj = x.toArray();
		Object[] yObj = y.toArray();
		
		xPoint = new int[xObj.length];
		yPoint = new int[yObj.length];
		
		for (int i = 0; i < xObj.length; i++)
		{
			xPoint[i] = ((Integer)xObj[i]).intValue();
		}
		
		for (int j = 0; j < yObj.length; j++)
		{
			yPoint[j] = ((Integer)yObj[j]).intValue();
		}
		
		koch = new Polygon(xPoint, yPoint, vertex);
		path = new GeneralPath(koch);
		path.moveTo(xPoint[0], yPoint[0]);
		
		for (int k = 1; k < xPoint.length; k++)
		{
			path.lineTo(xPoint[k], yPoint[k]);
		}
		
		path.closePath();
		g2.draw(path);
		
	}
}


















