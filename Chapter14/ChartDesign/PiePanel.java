
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.font.*;
import java.awt.*;

public class PiePanel extends JPanel
{
    private int[] data;
    private int total;
    Font font;
    private boolean showMarkers;
	
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
  
    public PiePanel()
    {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
        data = new int[] { 100, 200, 300, 400 };
        total = 0;
        font = new Font("ludica sans regular", Font.PLAIN, 22);
        showMarkers = false;
		
        for(int j = 0; j < data.length; j++)
		{
            total = total + data[j];
        }
		setBackground(Color.white);
    }
  
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        double dia = Math.min(w,h)*0.85;
		
        // circle
        g2.draw(new Ellipse2D.Double(w/2 - dia/2, h/2 - dia/2, dia, dia));
		
        // datum is zero == 3 o'clock position, theta increases clockwise
        double theta = 0;
		double phi;
        double x;
		double y;
		double textWidth;
		double textHeight;
		double cx;
		double cy;
		double sx;
		double sy;
		
        for(int j = 0; j < data.length; j++)
        {
            phi = 2*Math.PI * data[j]/total;
            x = w/2 + (dia/2) * Math.cos(theta + phi);
            y = h/2 + (dia/2) * Math.sin(theta + phi);
			
            g2.draw(new Line2D.Double(w/2, h/2, x, y));
            g2.setFont(font);
			
            String s = String.valueOf(data[j]);
			
            FontRenderContext frc = g2.getFontRenderContext();
            textWidth = font.getStringBounds(s, frc).getWidth();
            LineMetrics lm = font.getLineMetrics(s, frc);
            textHeight = lm.getAscent();
			
            // center of text box at 7/12 along midline of wedge
            cx = w/2 + (dia/2) * Math.cos(theta + phi/2) * 7/12;
            cy = h/2 + (dia/2) * Math.sin(theta + phi/2) * 7/12;
			
            if(showMarkers)
			{
                showMarker(g2, cx, cy);
			}
			
            // text origin at lower left of box
            sx = cx - textWidth/2;
            sy = cy + textHeight/2;
			
            if(showMarkers)
            {
                showMarker(g2, sx, sy);
                g2.draw(new Rectangle2D.Double(sx, sy - textHeight, textWidth, textHeight));
            }
			
            g2.drawString(s, (float)sx, (float)sy);
            theta = theta + phi;
        }
    }

    public void showMarker(Graphics2D g2, double x, double y)
    {
        g2.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
    }
}