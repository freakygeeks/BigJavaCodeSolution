//Chapter11 - Exercise P11.11

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JComponent;

public class RandomDrawable extends JComponent
{
	private Random gen = new Random();

	public void paintComponent (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 1; i < 10; i++)
			{
			randomDrawable().draw(g2);
			}
	}
	
	public Drawable randomDrawable()
	{
		Drawable aDraw = new Car(0,0);
		
		int x = gen.nextInt(getWidth());
		int y = gen.nextInt(getHeight());
		
		if(gen.nextBoolean())
			{
			aDraw = new Car(x, y);
			}
		else
			{
			aDraw = new House(x, y);
			}

		return aDraw;
	}
}