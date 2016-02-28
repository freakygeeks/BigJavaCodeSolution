//https://answers.yahoo.com/question/index?qid=20081123095642AA7pHSD
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.awt.geom.Ellipse2D; 
import java.awt.geom.Point2D; 
import java.util.ArrayList; 
import java.util.Random; 

import javax.swing.JComponent; 
import javax.swing.JFrame; 

public class CloudTest extends JFrame { 

public static void main(String args[]) { 

JFrame frame = new JFrame(); 

final int FRAME_WIDTH = 300; 
final int FRAME_HEIGHT = 400; 

frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); 
frame.setTitle("Cloud : 1 Files Class"); 

frame.addWindowListener(new WindowAdapter() { 
public void windowClosing(WindowEvent e) { 
System.exit(0); 
} 
}); 

CloudComponent component = new CloudComponent(); 

frame.add(component); 
frame.setVisible(true); 

} 
} 

class CloudComponent extends JComponent { 

public void paint(Graphics g) { 

Graphics2D g2 = (Graphics2D) g; 

Random generator = new Random(); 

final int CLOUD_SIZE = 100; 
Cloud randomCloud = new Cloud(CLOUD_SIZE); 

for (int i = 0; i < CLOUD_SIZE; i++) { // generate two random numbers 
// between 100 and 200 

double x = 100 + 100 * generator.nextDouble(); 
double y = 100 + 100 * generator.nextDouble(); 

randomCloud.add(new Point2D.Double(x, y)); 
} 

randomCloud.draw(g2); 
} 
} 

class Cloud { 

private ArrayList<Point2D.Double> cloudList; 

public Cloud(int n) { 
cloudList = new ArrayList<Point2D.Double>(n); 
} 

public void add(Point2D.Double p) { 
cloudList.add(p); 
} 

public void draw(Graphics2D g2) { 
final double SMALL_CIRCLE_RADIUS = 2; 

for (int i = 0; i < cloudList.size(); i++) { 
Ellipse2D.Double smallCircle = new Ellipse2D.Double(cloudList 
.get(i).getX() 
- SMALL_CIRCLE_RADIUS, cloudList.get(i).getY() 
- SMALL_CIRCLE_RADIUS, 2 * SMALL_CIRCLE_RADIUS, 
2 * SMALL_CIRCLE_RADIUS); 

g2.draw(smallCircle); 
} 
} 

}