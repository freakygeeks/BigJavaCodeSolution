//Chapter11 - Project P11.1

import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.Timer; 
import javax.swing.JComponent;

public class AnimationPanel extends JComponent
{ 
	private MoveableShape shapeCar;
	private MoveableShape shapeRect;
	private int xC; 
	private int yC; 
	private int xR;
	private int yR;
	
	public AnimationPanel() 
	{ 
		xC = 100; 
		yC = 100; 
		xR = 100;
		yR = 200;
		shapeCar =  new Car(xC, yC);
		shapeRect = new Rectangle (xR, yR);

		class AnimationPanelMover implements ActionListener 
		{ 
			public void actionPerformed(ActionEvent event) 
			{ 
				shapeCar.translate(1,0);
				shapeRect.translate(1,0);
				repaint(); //call the paint to be repaint
			} 
		} 
		
		class AnimationIcon 
		{
			public AnimationIcon (MoveableShape shapeCar, MoveableShape shapeRect)
			{
				shapeCar = shapeCar;
				shapeRect = shapeRect;
			}		
		}

		AnimationPanelMover listener = new AnimationPanelMover(); //for car to be move in this variable

		final int DELAY = 100; // milliseconds between timer ticks 
		Timer t = new Timer(DELAY, listener); //variable is move based on timer
		t.start(); //start the move
	} 

	public void paint(Graphics g) 
	{ 
		final Graphics2D g2 = (Graphics2D)g; 
		shapeCar.draw(g2);
		shapeRect.draw(g2);
	} 
} 