import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Cloud extends JComponent
{
	 private ArrayList<Point2D.Double> list = new ArrayList<Point2D.Double>();
	 
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
}