//Chapter11 - Exercise P11.15

import javax.swing.JFrame;

public class RectangleAnimateTester
{
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
	
		frame.setTitle ("Animate Rectangle");
		frame.setSize (1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		RectangleAnimate myComponent = new RectangleAnimate();
		frame.add(myComponent);
		
		frame.setVisible(true);
	}
}