import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * An example to show how to translate and rotate graphical shapes in Java
 * @author Barbara Lerner
 * @version Feb 7, 2012
 *
 */
public class TranslateRotate extends JComponent implements ActionListener {
	// The fields where the user enters the desired translation and rotation values.
	private JTextField xField;
	private JTextField yField;
	private JTextField rotateField;
	
	// The shape that is drawn, moved and rotated
	private MovableRectangle shape;
	
	/**
	 * Create the starting diagram.  This is a rectangle centered at 0, 0.
	 */
	public TranslateRotate() {
		shape = new MovableRectangle();
	}
	
	/**
	 * Draws the translated and rotated shape
	 * @param g the surface we are drawing on 
	 */
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		shape.paint(g, getWidth(), getHeight());
	}
	
	/**
	 * Creates the panel where the user enters translation and rotation information
	 * @return the panel created
	 */
	private Component createControlPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout (new BoxLayout (buttonPanel, BoxLayout.Y_AXIS));
		
		JPanel translatePanel = new JPanel();
		translatePanel.add (new JLabel ("Translate horizontally"));
		xField = new JTextField(5);
		translatePanel.add(xField);
		translatePanel.add (new JLabel ("Translate vertically"));
		yField = new JTextField(5);
		translatePanel.add(yField);
		buttonPanel.add(translatePanel);
		
		JPanel rotatePanel = new JPanel();
		rotatePanel.add (new JLabel ("Rotate (multiples of pi)"));
		rotateField = new JTextField(5);
		rotatePanel.add(rotateField);
		buttonPanel.add(rotatePanel);
		
		JButton applyButton = new JButton ("Apply");
		applyButton.addActionListener(this);
		buttonPanel.add(applyButton);
		
		return buttonPanel;
	}

	/**
	 * When the user clicks the apply button, get the translation and rotation 
	 * values out of the fields and repaint the display.
	 */
	public void actionPerformed(ActionEvent event) {
		int x;
		String xText = xField.getText();
		if (xText.equals("")) {
			x = 0;
		}
		else {
			x = Integer.parseInt(xText);
		}
		
		int y;
		String yText = yField.getText();
		if (yText.equals("")) {
			y = 0;
		}
		else {
			y = Integer.parseInt(yText);
		}
		
		double radians;
		String rotateText = rotateField.getText();
		if (rotateText.equals("")) {
			radians = 0;
		}
		else {
			radians = Double.parseDouble(rotateText) * Math.PI;
		}
		
		// Tell the shape where its new location and angle should be based
		// on the user input.
		shape.setPosition(x, y, radians);
		
		// Redraw the window.
		repaint();
	}

	/**
	 * Runs the program.
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Translate - rotate example");
		
		// Create the display
		TranslateRotate axes = new TranslateRotate();
		Container contentPane = f.getContentPane();
		contentPane.add(axes, BorderLayout.CENTER);
		contentPane.add(axes.createControlPanel(), BorderLayout.SOUTH);

		f.setSize(new Dimension(500, 500));
		f.setVisible(true);
	}

}