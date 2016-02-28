//Chapter2
import java.awt.Rectangle;

public class MoveTester2
{
	public static void main (String[] args)
	{
	Rectangle box = new Rectangle (5, 10, 20, 30);
	
	//to move the rectangle
	box.translate (15, 25);
	
	//to print the moved rectangle
	System.out.println ("After moving the top-left corner is : ");
	System.out.println (box.getX());
	System.out.println (box.getY());
	}
}