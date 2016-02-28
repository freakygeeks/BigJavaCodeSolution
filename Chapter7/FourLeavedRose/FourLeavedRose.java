//Chapter7 - Exercise P7.18 http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch06/c06_exp_6_21 http://www.maplesoft.com/applications/view.aspx?SID=87677&view=html http://www.tek-tips.com/viewthread.cfm?qid=186405

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class FourLeavedRose extends JComponent
{
	private double r;
	private double x;
	private double y;
	private double aX;
	private double aY;
	private double n;
	private double rad;
	
	FourLeavedRose()
	{
	r = 0;
	x = 0;
	y = 0;
	aX = 0;
	aY = 0;
	n = 5000;
	rad = 360/n;
	}
	
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	for (int i = 1; i <= n; i++)
		{
		r = Math.cos(2*(i*rad*Math.PI/180));
		x = r*Math.cos(i*rad*Math.PI/180);
		y = r*Math.sin(i*rad*Math.PI/180);
		
		aX = x;
		aY = y;
		
		Line2D.Double rose = new Line2D.Double (250+x*200, 250+y*200, 250+aX*200, 250+aY*200);
		g2.setColor(Color.RED);
		g2.fill(rose);
		g2.draw(rose);
		}
	}
}