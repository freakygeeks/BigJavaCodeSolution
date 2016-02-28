//Chapter11 - Exercise P11.14

import javax.swing.JFrame;

public class RectangleMoveTester
{
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
	
		frame.setTitle ("Animate Rectangle");
		frame.setSize (1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		RectangleMove myComponent = new RectangleMove();
		frame.add(myComponent);
		
		frame.setVisible(true);
	}
}