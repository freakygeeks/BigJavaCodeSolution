import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 * An example to show how to translate and rotate graphical shapes in Java
 * @author Barbara Lerner
 * @version Feb 7, 2012
 *
 */
public class MovableRectangle {
	// The size of the rectangle
	private static final int POLYGON_HEIGHT = 200;
	private static final int POLYGON_WIDTH = 100;

	// The left coordinate of the shape
	private int x;
	
	// The top coordinate of the shape
	private int y;
	
	// The amount of rotation, measured in radians
	private double radians;
	
	// The shape that is translated and rotated.  Its center is at (0, 0)
	private Polygon shape;
	
	/**
	 * Create the starting diagram.  This is a rectangle centered at 0, 0.
	 */
	public MovableRectangle() {
		shape = new Polygon();
		shape.addPoint(-POLYGON_WIDTH/2, POLYGON_HEIGHT/2);
		shape.addPoint(-POLYGON_WIDTH/2, -POLYGON_HEIGHT/2);
		shape.addPoint(POLYGON_WIDTH/2, -POLYGON_HEIGHT/2);
		shape.addPoint(POLYGON_WIDTH/2, POLYGON_HEIGHT/2);
	}
	
	/**
	 * Translates and rotates the graphics surface based on the values entered
	 * by the user.  Draws x & y axes and the polygon centered at (0,0)
	 * @param g the surface we are drawing on 
	 * @param width the width of the component we are drawing
	 * @param height the height of the component we are drawing
	 */
	public void paint (Graphics g, int width, int height) {
		Graphics2D g2d = (Graphics2D) g;
		
		// Set the translation and rotation values
		g2d.translate(x, y);
		g2d.rotate(radians);
		
		// Draw the axes
		g.setColor(Color.BLACK);
		g.drawLine(-width, 0, width, 0);
		g.drawLine(0, -height, 0, height);
		g.drawString("(0, 0)", 5, 15);
		
		// Draw the shape
		g2d.setColor(Color.RED);
		g2d.drawPolygon(shape);

		// Undo the translation and rotation 
		g2d.rotate(-radians);
		g2d.translate(-x, -y);
	}

	/**
	 * Changes the position and angle of the shape
	 * @param x the x value for the center of the rectangle
	 * @param y the y value for the center of the rectangle
	 * @param radians the angle of rotation, measured clockwise from upright
	 */
	public void setPosition(int x, int y, double radians) {
		this.x = x;
		this.y = y;
		this.radians = radians;
	}
	
}