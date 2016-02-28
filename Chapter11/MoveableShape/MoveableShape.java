//Chapter11 - Project P11.1
//http://www.johnloomis.org/ece538/notes/Horstmann/ch04/animation/Animation.html

import java.awt.Graphics2D;

public interface MoveableShape
{
	public void draw (Graphics2D g2);
	public void translate (double x, double y);

}