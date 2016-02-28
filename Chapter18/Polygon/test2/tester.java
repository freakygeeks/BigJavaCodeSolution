import java.awt.geom.*;

public class tester{

public static void main(String[] args){
IrregularPolygon app = new IrregularPolygon();
Point2D.Double myShape = new Point2D.Double ();
app.input(myShape);
double are = app.area();
System.out.println("The area of your irregular polygon is " + are + " square units");
double per = app.perimeter();
System.out.println("The perimeter of your irregular polygon is " + per + " units");
app.draws();


}
}