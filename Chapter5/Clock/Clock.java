//Chapter5 - Project 5.1
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComponent;

public class Clock extends JComponent
{
	private int xCenter;
	private int yCenter;
	private int clockRadius;
	
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	GregorianCalendar cal = new GregorianCalendar();
	
	// Initialize clock parameters
    clockRadius =(int)(Math.min(getSize().width, getSize().height)*0.7*0.5);
    xCenter = (getSize().width)/2;
    yCenter = (getSize().height)/2;

    // Draw circle
	Ellipse2D.Double roundClock = new Ellipse2D.Double(xCenter - clockRadius,yCenter - clockRadius,2*clockRadius, 2*clockRadius);
    
	g2.setColor(Color.BLUE);
	g2.draw(roundClock);
    g2.drawString("12",xCenter, yCenter-clockRadius+20);
    g2.drawString("9",xCenter-clockRadius+10,yCenter);
    g2.drawString("3",xCenter+clockRadius-10,yCenter);
    g2.drawString("6",xCenter,yCenter+clockRadius-10);
	g2.drawString("1", xCenter+clockRadius-120, yCenter-clockRadius+60);
	g2.drawString("2", xCenter+clockRadius-60, yCenter-clockRadius+120);
	g2.drawString("4", xCenter+clockRadius-60, yCenter+clockRadius-120);
	g2.drawString("5", xCenter+clockRadius-120, yCenter+clockRadius-60);
	g2.drawString("7", xCenter-clockRadius+120, yCenter+clockRadius-60);
	g2.drawString("8", xCenter-clockRadius+60, yCenter+clockRadius-120);
	g2.drawString("10",xCenter-clockRadius+60, yCenter-clockRadius+120);
	g2.drawString("11",xCenter-clockRadius+120, yCenter-clockRadius+60);
	
	//draw minute hand
	int minute = (int)cal.get(GregorianCalendar.MINUTE);
	int mLength = (int)(clockRadius*0.8);
	int xMinute = (int)(xCenter+mLength*Math.sin(minute*(2*Math.PI/60)));
	int yMinute = (int)(yCenter-mLength*Math.cos(minute*(2*Math.PI/60)));
	g2.setColor(Color.RED);
	g2.drawLine(xCenter, yCenter, xMinute, yMinute);
	
	//draw hour hand
	int hour = (int)cal.get(GregorianCalendar.HOUR);
	int hLength = (int)(clockRadius*0.6);
	int xHour = (int)(xCenter+hLength*Math.sin((hour+minute/60)*(2*Math.PI/12)));
	int yHour = (int)(yCenter-hLength*Math.cos((hour+minute/60)*(2*Math.PI/12)));
	g2.setColor(Color.GREEN);
	g2.drawLine(xCenter, yCenter, xHour, yHour);
	}
}