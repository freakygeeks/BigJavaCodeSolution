//Chapter2
import java.awt.Rectangle;

public class MoveTester
{
	public static void main (String[] args)
	{
	Rectangle box = new Rectangle(5, 10, 20, 30);
	
	System.out.println ("The X value is : " + box.getX());
	System.out.println ("The Y value is : " + box.getY());
	System.out.println ("The width value is : " + box.width);
	System.out.println ("The height value is : " + box.height);
	}
}