//Chapter5 - Example 5.6
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class ColorSquareComponent extends JComponent
{
	private Color fillColor;
	
	public ColorSquareComponent(Color aColor)
	{
	fillColor = aColor;
	}
	
	public void paintComponent(Graphics g)
	{
	final int SQUARE_LENGTH = 100;
	
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(fillColor);
	
	Rectangle square = new Rectangle ((getWidth()-SQUARE_LENGTH/2), (getHeight()-SQUARE_LENGTH/2), SQUARE_LENGTH, SQUARE_LENGTH);
	g2.fill(square);
	}
}