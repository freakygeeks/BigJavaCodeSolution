import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;
import java.awt.Polygon;
public class KochComponent extends JComponent
{
   public KochComponent()
   {
      numIterations =  1;
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
      int length = Math.min(getWidth(), getHeight()) * 2 / 3;
      int x1 = 10;
      int y1 = length / 2;
      int x2 = x1 + length;
      int y2 = y1;
      int x3 = x1 + (length / 2);
      int y3 = y1 + length;
      draw(g2, numIterations, x1, y1, x2, y2);
      draw(g2, numIterations, x2, y2, x3, y3);
      draw(g2, numIterations, x3, y3, x1, y1);
   }
   private void draw(Graphics2D g2, int iteration,
      double x1, double y1, double x2, double y2)
   {
     
     
      x.add((int)x1);
      x.add((int)x2);
      y.add((int)y1);
      y.add((int)y2);
      
      double n = 3 * Math.pow(4, iteration-1);
      vertex = (int)n;
      
     
      
   }
   public void paint(Graphics g)
   {
      paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      super.paint(g2);
      Object[] obj = x.toArray();
      Object[] obj2 = y.toArray();
      xPoints = new int[obj.length];
      yPoints = new int[obj2.length];
      for (int k = 0; k < obj.length; k++)
      {
          xPoints[k] = ((Integer)obj[k]).intValue();
      }
      for (int l = 0; l < obj2.length; l++)
      {
          yPoints[l] = ((Integer)obj2[l]).intValue();
      }
      Polygon koch = new Polygon(xPoints, yPoints, vertex);
      path = new GeneralPath(koch);
      path.moveTo(xPoints[0], yPoints[0]);
      for (int i = 1; i < xPoints.length; i++) 
      {
         path.lineTo(xPoints[i], yPoints[i]);
      }
      path.closePath();
       g2.draw(path);
       
    }
       
   private int numIterations;
   private ArrayList<Integer> x;
   private ArrayList<Integer> y;
   private GeneralPath path;
   private int vertex;
   private int[] xPoints;
   private int[] yPoints;
}