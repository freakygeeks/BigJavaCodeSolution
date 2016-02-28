//Chapter5 - Exercise P5.12
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class BarChart extends JComponent
{
	public void paintComponent (Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
	
	Line2D.Double lineY = new Line2D.Double (180, 30, 180, 160);
	Line2D.Double GG = new Line2D.Double (180, 50, 600, 50);
	Line2D.Double B = new Line2D.Double (180, 80, 340, 80);
	Line2D.Double DM = new Line2D.Double (180, 110, 400, 110);
	Line2D.Double M = new Line2D.Double (180, 140, 560, 140);
	Line2D.Double lineX = new Line2D.Double (180, 160, 700, 160);
	
	g2.draw(lineY);
	g2.draw(GG);
	g2.draw(B);
	g2.draw(DM);
	g2.draw(M);
	g2.draw(lineX);
	g2.drawString("Y-Axis (Bridge Name)", 180, 25);
	g2.drawString("X-Axis (Longest Span in ft)", 705, 160);
	g2.drawString("Golden Gate", 50, 50);
	g2.drawString("Brooklyn", 50, 80);
	g2.drawString("Delaware Memorial", 50, 110);
	g2.drawString("Mackinac", 50, 140);
	g2.drawString("4200", 605, 50);
	g2.drawString("1595", 345, 80);
	g2.drawString("2150", 405, 110);
	g2.drawString("3800", 565, 140);
	}
}