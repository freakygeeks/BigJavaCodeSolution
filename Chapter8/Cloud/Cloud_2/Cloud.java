/** COPYRIGHT(C) 2008. Loc Phan. All Rights Reserved.
    A class that draw 100 random points as a cloud
    @author Loc Phan
    @version 1.01 2008-11-11
	http://tienloc47school.googlecode.com/svn/trunk/CS46A/Lab11/src/CloudViewer.java
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;


public class Cloud extends JComponent
{
   /**Take in a point
    * 
    * @param aPoint Point2D
    */
   public void add(Point2D.Double aPoint)
   {
       list.add(aPoint);
   }
   /**Draw points
    * 
    * @param g2 Object Graphics2D
    */
   public void draw(Graphics2D g2)
   {
      for(int i=0;i<list.size();i++)
      {   
         Point2D.Double point;
         point = list.get(i);
         Ellipse2D.Double circle = new Ellipse2D.Double(point.x,point.y,10,10);
         g2.draw(circle);
      }
   }
   /**Draw points
    * 
    */
   public void paint(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      Random coordinate = new Random();
      
      for(int i=0;i<100;i++)
      {
         Point2D.Double apoint = new Point2D.Double(coordinate.nextInt(450),coordinate.nextInt(450));
         Cloud pic = new Cloud();
         pic.add(apoint);
         pic.draw(g2);
      }  
   }
   private ArrayList<Point2D.Double> list = new ArrayList<Point2D.Double>();
}