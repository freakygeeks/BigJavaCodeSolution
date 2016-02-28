//Chapter2 - Exercise P2.4
import java.awt.Rectangle;

public class Intersection
{
	public static void main (String[] args)
	{
	Rectangle r1 = new Rectangle (1, 1, 2, 4);
	Rectangle r2 = new Rectangle (2, 2, 4, 2);
	
	boolean r4 = r1.intersects(r2);
	Rectangle r3 = r1.intersection(r2);
	
	System.out.println ("Does rectangle overlap? : " + r4);
	System.out.println ("Location X : " + r3.getX());
	System.out.println ("Location Y : " + r3.getY());
	System.out.println ("Width : " + r3.getWidth());
	System.out.println ("Height : " + r3.getHeight());
	}
}