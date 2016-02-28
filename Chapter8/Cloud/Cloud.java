//Chapter8 - Exercise P8.7
//http://www.codemiles.com/viewtopic.php?f=20&t=8886&view=next
//https://answers.yahoo.com/question/index?qid=20081123095642AA7pHSD
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch07/c07_exp_7_17
//http://stackoverflow.com/questions/25374641/how-to-write-a-java-program-to-make-a-cloud-of-random-dots

import java.awt.Graphics2D;//use method draw (Graphics2D g2)
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Cloud extends JComponent//process random location input of x and y and draw the ellipse based on arraylist
{
	private ArrayList<Point2D.Double> listCloud = new ArrayList<Point2D.Double>();//create an ArrayList for Point2D
	
	public Cloud()
	{
	}
	
	//create method to add arraylist element in Point2D.Double
	public void add(Point2D.Double aPoint)//define input variable for Point2D
	{
	listCloud.add(aPoint);//append add method to ArrayList created
	}
	
	//create method to draw an Ellipse2D object located in Point2D.Double
	public void draw(Graphics2D g2)
	{
	for (int i = 0; i < listCloud.size(); i++)//create loop to iterate over arraylist element
		{
		Point2D.Double pointCloud;//create variable for Point2D to be draw for x and y
		pointCloud = listCloud.get(i);//get element in arraylist element and append to variable created in a loop
		Ellipse2D.Double circleCloud = new Ellipse2D.Double(pointCloud.x, pointCloud.y, 10, 10);//create Ellipse
		g2.setColor(Color.RED);
		g2.draw(circleCloud);//draw Ellipse	
		}
	}
}
