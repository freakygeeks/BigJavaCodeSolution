import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class RectanglePanel extends JPanel
{
	private Rectangle box;
	private static final int X = 100;
	private static final int Y = 100;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	
	public RectanglePanel()
	{
		box = new Rectangle(X, Y, WIDTH, HEIGHT);
	}
	
	public void moveBy(int x, int y)
	{
		box.translate(x, y);
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(box);
	}
}