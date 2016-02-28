//Chapter11 - Exercise P11.5

import java.awt.Rectangle;

public class RectangleMeasurer implements Measurer
{
	public double measure (Object anObject)
	{
	Rectangle aRectangle = (Rectangle) anObject;
	double area = aRectangle.getWidth()*aRectangle.getHeight();
	return area;
	}
}