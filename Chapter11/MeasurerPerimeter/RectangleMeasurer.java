//Chapter11 - Exercise P11.6

import java.awt.Rectangle;

public class RectangleMeasurer implements Measurer
{
	public double measureArea (Object anObject)
	{
	Rectangle aRectangle = (Rectangle) anObject;
	double area = aRectangle.getWidth()*aRectangle.getHeight();
	return area;
	}
	
	public double measurePerimeter (Object anObject)
	{
	Rectangle aRectangle = (Rectangle) anObject;
	double perimeter = (2*aRectangle.getWidth())+(2*aRectangle.getHeight());
	return perimeter;
	}
}