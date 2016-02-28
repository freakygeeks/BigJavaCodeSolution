//Chapter6 -  Exercise 6.6

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class TwoCircleIntersectTest extends JComponent
{
	private double a1;
	private double b1;
	private double r1;
	private double a2;
	private double b2;
	private double r2;
	
	public TwoCircleIntersectTest(double xa1, double yb1, double rad1, double xa2, double yb2, double rad2)
	{	
	a1 = xa1;
	b1 = yb1;
	r1 = rad1;
	a2 = xa2;
	b2 = yb2;
	r2 = rad2;
	}
	
	public void paintComponent(Graphics g)
	{

	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double circle1 = new Ellipse2D.Double (a1, b1, r1, r1);
	Ellipse2D.Double circle2 = new Ellipse2D.Double (a2, b2, r2, r2);
	
	//first equation
	double Xa1 = (-2)*(a1);
	double Yb1 = (-2)*(b1);
	double c = Math.pow(a1,2)+Math.pow(b1,2)-Math.pow(r1,2);
	
	//second equation
	double Xa2 = (-2)*(a2);
	double Yb2 = (-2)*(b2);
	double d = Math.pow(a2,2)+Math.pow(b2,2)-Math.pow(r2,2);
	
	//value for x
	double e = c-d;
	double f = (2*(b1-b2)/2*(a1-a2));
	double k = e/2*(a1-a2);
	
	//value for quadratic
	double h = Math.pow(f,2)+1;
	double i = ((-2)*f*k)-((-2)*f*a1)-(2*b1);
	double j = Math.pow(k,2)-(2*k*a1)+c;
	
	//solution for both of y point
	double solutionY1 = (double)((-i+(Math.sqrt((Math.pow(i,2))-(4*h*j))))/(2*h)); 
	double solutionY2 = (double)((-i-(Math.sqrt((Math.pow(i,2))-(4*h*j))))/(2*h));
	
	//solution for both of x point
	double solutionX1 = (-solutionY1)*(f)+k;
	double solutionX2 = (-solutionY2)*(f)+k;
	
	double discrimi = (double)((i*i)-4*h*j);
	if (discrimi > 0)
		{
		g2.draw(circle1);
		String label1 = "(" + solutionX1 + "," + solutionX1 + ")";
		g2.drawString(label1, (float) solutionX1, (float) solutionY1);
		
		g2.draw(circle2);
		String label2 = "(" + solutionX2 + "," + solutionX2 + ")";
		g2.drawString(label2, (float) solutionX2, (float) solutionY2);
		}
	else
		g2.drawString("There is no intersection between circle.",10, 100);
	}
}