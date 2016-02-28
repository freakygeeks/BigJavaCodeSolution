//Chapter8 - Exercise P8.7

import java.awt.Graphics;//use method paintComponent (Graphics g)
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JComponent;

public class CloudComponent extends JComponent//process user input to locate the random point for x and y and transfer data to cloud.java
{
	private int num;

	public CloudComponent(int aNum)
	{
	num = aNum;
	}
	
	//create method to point the cloud position for x and y
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Cloud calc = new Cloud();//create instance of object Cloud
	Random gen = new Random();//create instance of object Random
	
	double x = 0;//initialize value x
	double y = 0;//initialize value y
	
	for (int i = 0; i < num; i++)//create a loop to iterate over 100 times
		{
		x = getWidth() * gen.nextDouble();//get random position value for x
		y = getHeight() * gen.nextDouble();//get random position value for y
		
		calc.add(new Point2D.Double(x,y));//append add method to variable of Cloud object crated
		}	
	calc.draw(g2);//draw the position
	}	
}