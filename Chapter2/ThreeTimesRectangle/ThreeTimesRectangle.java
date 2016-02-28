//Chapter2 - Exercise P2.1, P2.2 & P2.3
import java.awt.Rectangle;

public class ThreeTimesRectangle
{
	public static void main (String[] args)
	{
	Rectangle box = new Rectangle (1, 1, 1, 1);
	double width = box.getWidth()*3;
	double height = box.getHeight()*3;
	
	System.out.println ("Original location for X : " + box.getX());
	System.out.println ("Original location for Y : " + box.getY());
	System.out.println ("Original width : " + box.getWidth());
	System.out.println ("Original height : " + box.getHeight());
	System.out.println ();
	System.out.println ("Three times location for X : " + box.getX());
	System.out.println ("Three times location for Y : " + box.getY());
	System.out.println ("New width : " + width);
	System.out.println ("New height : " + height);
	}
}