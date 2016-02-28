//Chapter5 - Exercise P5.5
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JComponent;

public class TwoCircleColor extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Color customColor = new Color (128, 0, 128);
	
	Ellipse2D.Double circleStandard = new Ellipse2D.Double(50, 50, 100, 100);
	Ellipse2D.Double circleCustom = new Ellipse2D.Double(160, 50, 100, 100);
		
	g2.setColor(Color.PINK);
	g2.fill(circleStandard);
	g2.draw(circleStandard);
	
	g2.setColor(customColor);
	g2.fill(circleCustom);
	g2.draw(circleCustom);
	}
}
	