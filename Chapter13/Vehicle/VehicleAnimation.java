//Chapter 13 - Exercise 13.7

import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class VehicleAnimation extends JComponent
{
	private Random gen;
	
	public VehicleAnimation()
	{
		gen = new Random();
	}
	
	public void paint (Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 1; i <=10; i++)
			{
				randomVehicle().draw(g2);
			}
	}
	
	public Vehicle randomVehicle()
	{
		Vehicle v = null;
		if (gen.nextBoolean())
			{
				v = new Car();
			}
		else
			{
				v = new Truck();
			}
			
		v.setLocation(gen.nextInt(getWidth()), gen.nextInt(getHeight()));
		return v;
	}

}