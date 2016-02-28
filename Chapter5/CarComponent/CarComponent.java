//Chapter5 - Example 5.5 & Exercise P5.16
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JComponent;

public class CarComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
	Graphics2D g2 = (Graphics2D) g;
			
	int x = getWidth() - Car.WIDTH;
	int y = getHeight() - Car.HEIGHT;
	
	Car car1 = new Car(0,0, Color.RED);
	Car car2 = new Car(x,y, Color.BLUE);
	//Car car3 = new Car(50,50, Color.GREEN);
	//Car car4 = new Car(100, 100, Color.YELLOW);
	//Car car5 = new Car(150, 150, Color.WHITE);
	//Car car6 = new Car(200, 200, Color.PINK);
	//Car car7 = new Car(250, 250, Color.BLACK);
	
	car1.draw(g2);
	car2.draw(g2);
	//car3.draw(g2);
	//car4.draw(g2);
	//car5.draw(g2);
	//car6.draw(g2);
	//car7.draw(g2);
	}
}
	