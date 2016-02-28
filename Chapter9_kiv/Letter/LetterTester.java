//Chapter 9 - Exercise 9.12

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class LetterTester extends Applet
{
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		final int WIDTH = 30;
		final int HEIGHT = 50;
		final int SPACING = 5;
		
		double x = 0;
		double y = 0;
		
		Letter myLetters = new Letter();
		
		myLetters.drawH(g2, new Point2D.Double(x, y));
		x = x + WIDTH + SPACING;
		
		myLetters.drawE(g2, new Point2D.Double(x, y));
		x = x + WIDTH + SPACING;
		
		myLetters.drawL(g2, new Point2D.Double(x, y));
		x = x + WIDTH + SPACING;
		
		myLetters.drawL(g2, new Point2D.Double(x, y));
		x = x + WIDTH + SPACING;
		
		myLetters.drawO(g2, new Point2D.Double(x, y));
		x = 0;
		
		y = y + HEIGHT + SPACING;
		
		myLetters.drawH(g2, new Point2D.Double(x, y));
		x = x + WIDTH + SPACING;
		
		myLetters.drawO(g2, new Point2D.Double(x, y));
		x = x + WIDTH + SPACING;
		
		myLetters.drawL(g2, new Point2D.Double(x, y));
		x = x + WIDTH + SPACING;
		
		myLetters.drawE(g2, new Point2D.Double(x, y));
   }

}