//Chapter11 - Exercise P11.11

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class RandomDrawable extends Applet 
{
	private Random gen = new Random();
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 1; i < 10; i++)
			{
			randomDrawable().draw(g2);
			}
	}
	
	public Drawable randomDrawable()
	{
		Drawable aDraw = null;
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