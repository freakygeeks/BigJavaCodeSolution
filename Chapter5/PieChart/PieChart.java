//Chapter5 - Exercise P5.13
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class PieChart extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Ellipse2D.Double pie = new Ellipse2D.Double(50, 50, 300, 300);
	Line2D.Double line1 = new Line2D.Double(200, 200, 200, 50);
	Line2D.Double line2 = new Line2D.Double(200, 200, 305, 305);
	Line2D.Double line3 = new Line2D.Double(200, 200, 70, 275);
	Line2D.Double line4 = new Line2D.Double(200, 200, 90, 95);
	
	g2.draw(pie);
	g2.draw(line1);
	g2.draw(line2);
	g2.draw(line3);
	g2.draw(line4);
	g2.drawString("Golden Gate :4200ft", 230, 120);
	}
}