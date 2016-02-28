//Chapter 14 - Project 14.1

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.Vector;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.RenderingHints;

public class PieChartPanel extends JPanel
{
	Font font;
	private int total;
    private boolean showMarkers;
	
	private Vector pies;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
  
    public PieChartPanel()
    {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pies = new Vector();
    }
  
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
		if (pies.size() == 0)
		{
			return;
		}
		
		PieChart p = (PieChart)pies.get(0);
		double max = p.getLength();
		double total = 0;
		
		for (int i = 1; i < pies.size(); i++)
		{
			p = (PieChart)pies.get(i);
			if (p.getLength() > max)
			{
				max = p.getLength();
				total = total + p.getLength();
			}
		}
			setBackground(Color.yellow);
			font = new Font("ludica sans regular", Font.PLAIN, 22);
			showMarkers = false;
			
			int w = getWidth();
			int h = getHeight();
			double dia = Math.min(w,h)*0.85;
		
			g2.draw(new Ellipse2D.Double(w/2 - dia/2, h/2 - dia/2, dia, dia));
			
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
		
		for (int i = 0; i<pies.size(); i++)
		{
			p = (PieChart)pies.get(i);
			
			phi = 2*Math.PI * p.getLength()/total;
            x = w/2 + (dia/2) * Math.cos(theta + phi);
            y = h/2 + (dia/2) * Math.sin(theta + phi);
			
            g2.draw(new Line2D.Double(w/2, h/2, x, y));
            g2.setFont(font);
			
            String s = String.valueOf(p.getLength());
			
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
				Rectangle2D.Double pie = new Rectangle2D.Double (sx, sy - textHeight, textWidth, textHeight);
				g2.setColor(p.getColor());
				g2.fill(pie);
				g2.setColor(Color.black);
				g2.draw(pie);
            }
			
            g2.drawString(p.getName(), (float)sx, (float)sy);
            theta = theta + phi;
		}
    }

    public void showMarker(Graphics2D g2, double x, double y)
    {
        g2.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
    }
	
	public void addPie(PieChart p)
	{
		pies.add(p);
		repaint();
	}
}