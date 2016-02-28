//Chapter2
import java.awt.Rectangle;

public class Perimeter
{
	public static void main (String[] args)
	{
	
	Rectangle box = new Rectangle (5, 10, 20, 30);
	double perimeter = (box.getWidth()*2)+(box.getHeight()*2);
	
	System.out.print (perimeter);
	}
}
	
	