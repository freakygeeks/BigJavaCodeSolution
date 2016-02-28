import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;
import java.util.Scanner;

public class IrregularPolygon{
private ArrayList <Point2D.Double> myPolygon;
DrawingTool myPencil;
SketchPad myPaper;
double x;
double y;
double peri;
double total;
int numPoints;
int pointsEntered;
int aPoint;

public IrregularPolygon(){
myPolygon = new ArrayList <Point2D.Double>();
x = 1;
y = 1;
peri = 0.0;
total = 0.0;
myPaper = new SketchPad(500,500);
myPencil = new DrawingTool(myPaper);


}
public void input (Point2D.Double aPoint){
Scanner in = new Scanner(System.in);
System.out.print("How many points are in your irregular polygon? ");
int numPoints = in.nextInt();
for (pointsEntered = 1; pointsEntered <= numPoints; pointsEntered++){
System.out.print("enter the x coordinate for your #" + pointsEntered + " point: ");
double x = in.nextDouble();
System.out.print("enter the y coordinate for your #" + pointsEntered + " point: ");
double y = in.nextDouble();
Point2D.Double myPoint = new Point2D.Double(x,y);
myPolygon.add(myPoint);
}
}

public void draws(){
myPencil.up();
myPencil.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
myPencil.down();

for(int i = 1; i < myPolygon.size(); i++){
myPencil.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
}
}

public double perimeter(){
for(int i = 0; i < myPolygon.size(); i++){
peri += ((Point2D.Double)myPolygon.get(i)).distance((Point 2D.Double)myPolygon.get(i + 1));
}
return peri;
}

public double area(){
for(int i = 0; i < myPolygon.size()-1; i++){
double myX = (myPolygon.get(i).getX());
double myY = (myPolygon.get(i).getY());
double my1X = (myPolygon.get(i + 1).getX());
double my1Y = (myPolygon.get(i + 1).getY());
total += (myX * my1Y - myY * my1X);
}
return .5 * total;
} 

}