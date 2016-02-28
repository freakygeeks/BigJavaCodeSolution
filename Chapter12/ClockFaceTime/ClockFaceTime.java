//Chapter 12 - Exercise 12.18
//x = cx + r * cos(a) & y = cy + r * sin(a)
//int xHour = (int)(xCenter+hLength*Math.sin((hour+minute/60)*(2*Math.PI/12)));
//int yHour = (int)(yCenter-hLength*Math.cos((hour+minute/60)*(2*Math.PI/12)));
//int xMinute = (int)(xCenter+mLength*Math.sin(minute*(2*Math.PI/60)));
//int yMinute = (int)(yCenter-mLength*Math.cos(minute*(2*Math.PI/60)));

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class ClockFaceTime
{
	private int h;
	private int m;
	private int xH;
	private int yH;
	private int xM;
	private int yM;
	int hLength;
	int mLength;
		
	public void setHour (int aH)
	{
		h = aH;
	}
	
	public void setMinutes (int aM)
	{
		m = aM;
	}
	
	public void getMinutes()
	{
		mLength = (int)(250*0.8);
		xM = (int) (350 + mLength*Math.cos((m+45)*(2*Math.PI/60)));
		yM = (int) (350 + mLength*Math.sin((m+45)*(2*Math.PI/60)));
	}
	
	public void getHour()
	{
		hLength = (int)(250*0.6);
		xH = (int) (350 + hLength*Math.cos(((((h*60)+m)-180)/60)*(2*Math.PI/12)));
		yH = (int) (350 + hLength*Math.sin(((((h*60)+m)-180)/60)*(2*Math.PI/12)));
	}
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double clock = new Ellipse2D.Double (100,100,500,500);
		Line2D.Double hour = new Line2D.Double (350, 350, xH, yH);
		Line2D.Double minutes = new Line2D.Double (350, 350, xM, yM);
		g2.draw(clock);
		g2.setColor(Color.BLUE);//for hour
		g2.draw(hour);
		g2.setColor(Color.RED);//for minutes
		g2.draw(minutes);
	}
}